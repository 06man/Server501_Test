package com.busanit501.api5012.service.ai;

import com.busanit501.api5012.dto.ai.tools.ToolsPredictionResponseDTO;
import java.io.IOException;

public interface AiUploadService {
    ToolsPredictionResponseDTO sendImageToDjangoServer(byte[] imageBytes, String filename) throws IOException;
}
