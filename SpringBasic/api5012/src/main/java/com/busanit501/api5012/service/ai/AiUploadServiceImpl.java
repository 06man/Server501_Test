package com.busanit501.api5012.service.ai;

import com.busanit501.api5012.dto.ai.image.AiPredictionResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
@Log4j2
public class AiUploadServiceImpl implements AiUploadService {

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper(); // JSON 파싱을 위한 ObjectMapper

    @Override
    @Transactional
    public AiPredictionResponseDTO sendImageToDjangoServer(byte[] imageBytes, String filename,  int teamNo) throws IOException {

        String djangoUrl;

        // ✅ 팀 번호에 따라 URL 분기
        switch (teamNo) {
            case 1:
                djangoUrl = "http://localhost:5000/predict/team1";
                break;
            case 2:
                djangoUrl = "http://localhost:5000/predict/team2";
                break;
            case 3:
                djangoUrl = "http://localhost:5000/predict/team3";
                break;
            default:
                throw new IllegalArgumentException("❌ 지원되지 않는 팀 번호입니다: " + teamNo);
        }
        log.info("🚀 Django 서버에 요청 전송: {}", djangoUrl);

        log.info("sendImageToDjangoServer filename : " + filename);
        // 이미지 파일을 MultipartBody로 구성
        RequestBody fileBody = RequestBody.create(imageBytes, MediaType.parse("image/jpeg"));

        // Multipart request body
        MultipartBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("image", filename, fileBody)
                .build();

        // Request 객체 생성
        Request request = new Request.Builder()
                .url(djangoUrl)
                .post(requestBody)
                .build();

        // 요청 실행
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // 응답 바디를 String으로 읽기
            String responseBody = response.body().string();
            log.info("responseBody : " + responseBody);

            // 응답을 PredictionResponseDTO 객체로 변환
            return objectMapper.readValue(responseBody, AiPredictionResponseDTO.class);
        }
    }
}
