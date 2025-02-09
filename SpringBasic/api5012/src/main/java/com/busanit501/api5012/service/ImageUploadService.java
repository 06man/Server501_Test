package com.busanit501.api5012.service;

import com.busanit501.api5012.dto.PredictionResponseDTO;
import java.io.IOException;

public interface ImageUploadService {
    PredictionResponseDTO sendImageToDjangoServer(byte[] imageBytes, String filename) throws IOException;
}
