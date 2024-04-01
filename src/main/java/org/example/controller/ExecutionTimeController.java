package org.example.controller;



import org.example.entity.MethodExecutionTime;
import org.example.service.ExecutionTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/execution-times")
public class ExecutionTimeController {

    @Autowired
    private ExecutionTimeService executionTimeService;

    @GetMapping
    public List<MethodExecutionTime> getExecutionTimes() {
        // executionTimeService для получения данных и возврата их клиенту
        return executionTimeService.findAll();
    }
}

