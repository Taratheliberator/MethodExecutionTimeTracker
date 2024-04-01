package org.example.controller;

import org.example.service.DataAnalysisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataAnalysisService dataAnalysisService;

    public DataController(DataAnalysisService dataAnalysisService) {
        this.dataAnalysisService = dataAnalysisService;
    }

    @PostMapping("/analyze")
    public ResponseEntity<Void> analyzeData(@RequestBody String data) {
        dataAnalysisService.analyzeDataAsync(data);
        return ResponseEntity.accepted().build();
    }
}
