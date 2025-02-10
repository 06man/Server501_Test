package com.busanit501.api5012.service.ai;


import com.busanit501.api5012.dto.ai.stock.StockPredictionRequestDTO;
import com.busanit501.api5012.dto.ai.stock.StockDataResponseDTO;
import com.busanit501.api5012.dto.ai.tools.ToolsPredictionResponseDTO;

import java.io.IOException;
import java.util.List;

public interface StockPredictionService {
    ToolsPredictionResponseDTO predictWithRNN(StockPredictionRequestDTO requestDTO) throws IOException;
    ToolsPredictionResponseDTO predictWithLSTM(StockPredictionRequestDTO requestDTO) throws IOException;
    ToolsPredictionResponseDTO predictWithGRU(StockPredictionRequestDTO requestDTO) throws IOException;
    List<StockDataResponseDTO> getStockData(String period) throws IOException;
}
