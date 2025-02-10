package com.busanit501.api5012.dto.ai.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)  // ✅ 예기치 않은 필드는 무시
public class AiPredictionResponseDTO {

    @JsonProperty("prediction")  // ✅ Flask 응답의 "prediction" 필드 추가
    private String prediction;

    private String filename; // Flask 응답의 filename 필드

    @JsonProperty("confidence")
    private String confidence; // 예측에 대한 신뢰도 (문자열로 변경, e.g., "95.00%")

    @JsonProperty("class_index")
    private int classIndex; // Flask 응답의 predicted_class 필드 매핑

    @JsonProperty("predicted_class")
    private String predictedClass; // Flask 응답의 predicted_class 필드


}