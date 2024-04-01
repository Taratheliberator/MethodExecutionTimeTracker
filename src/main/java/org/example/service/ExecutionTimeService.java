package org.example.service;

import org.example.entity.MethodExecutionTime;
import org.example.repository.MethodExecutionTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExecutionTimeService {

    @Autowired
    private MethodExecutionTimeRepository repository;

    public void saveExecutionTime(String methodName, long executionTime) {
        MethodExecutionTime methodExecutionTime = new MethodExecutionTime(methodName, executionTime);
        repository.save(methodExecutionTime);
    }

    public List<MethodExecutionTime> findAll() {
        return repository.findAll();
    }
}
