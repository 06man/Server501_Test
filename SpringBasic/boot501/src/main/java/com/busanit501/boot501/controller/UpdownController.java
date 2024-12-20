package com.busanit501.boot501.controller;

import com.busanit501.boot501.dto.upload.UploadFileDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class UpdownController {
    // application.propeties, 업로드 경로 설정.
    // com.busanit501.upload.path=c:\\upload\\springTest
    // 컨트롤러에서 사용해보기.
    @Value("${com.busanit501.upload.path}")
    private String uploadPath;

    @Tag(name = "파일 등록 post",
            description = "멀티파트 타입 형식 이용해서, post 형식으로 업로드테스트")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(UploadFileDTO uploadFileDTO) {
        log.info("UpdownController uploadFileDTO 내용 확인: "+uploadFileDTO);

        if(uploadFileDTO.getFiles() != null && uploadFileDTO.getFiles().size() > 0){
            uploadFileDTO.getFiles().forEach(multipartFile -> {
                log.info("UpdownController multipartFile.getOriginalFilename() 실제 파일 이름 확인 : "+multipartFile.getOriginalFilename());
            });
        }

        return null;
    }


}
