package org.example.service;

import org.example.annotation.TrackAsyncTime;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DataAnalysisService {

    @Async
    @TrackAsyncTime
    public void analyzeDataAsync(String data) {
        // Имитация длительной обработки данных
        try {
            long processingTime = 1000L + new Random().nextInt(5000); // 1-6 секунд
            Thread.sleep(processingTime);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
