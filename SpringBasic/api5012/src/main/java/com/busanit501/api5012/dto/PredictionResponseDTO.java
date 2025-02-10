package com.busanit501.api5012.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class PredictionResponseDTO {

    private String filename; // Flask 응답의 filename 필드

    @JsonProperty("confidence")
    private String confidence; // 예측에 대한 신뢰도 (문자열로 변경, e.g., "95.00%")

    @JsonProperty("class_index")
    private int classIndex; // Flask 응답의 predicted_class 필드 매핑

    @JsonProperty("predicted_class")
    private String predictedClass; // Flask 응답의 predicted_class 필드


}