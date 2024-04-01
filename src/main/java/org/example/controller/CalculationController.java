package org.example.controller;

import org.example.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {

    @Autowired
    private CalculationService calculationService;

    @GetMapping("/calculate")
    public String calculate(@RequestParam int input) {
        int result = calculationService.performCalculation(input);
        return "Result: " + result;
    }
}