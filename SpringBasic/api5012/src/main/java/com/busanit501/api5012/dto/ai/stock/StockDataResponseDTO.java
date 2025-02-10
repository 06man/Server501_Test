package com.busanit501.api5012.dto.ai.stock;

import lombok.Data;
import java.util.List;

@Data
public class StockDataResponseDTO {
    private String date;
    private double open;
    private double high;
    private double low;
    private double close;
}
