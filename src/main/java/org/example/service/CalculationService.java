package org.example.service;

import org.example.annotation.TrackTime;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    @TrackTime
    public int performCalculation(int input) {
        try {
            Thread.sleep(1000); // Задержка на 1 секунду
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Восстановление прерванного статуса
            throw new RuntimeException("Прервано во время ожидания", e);
        }
        return input * input; // Простое вычисление
    }
}
