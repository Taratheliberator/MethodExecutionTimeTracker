package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.service.ExecutionTimeService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.CompletableFuture;

@Aspect
@Component
public class TrackTimeAspect {

    @Autowired
    private ExecutionTimeService executionTimeService; // Сервис для хранения данных

    @Around("@annotation(org.example.annotation.TrackTime)")
    public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        executionTimeService.saveExecutionTime(joinPoint.getSignature().toString(), endTime - startTime);
        return result;
    }

    @Around("@annotation(org.example.annotation.TrackAsyncTime)")
    public Object trackAsyncTime(ProceedingJoinPoint joinPoint) throws Throwable {
        CompletableFuture.runAsync(() -> {
            try {
                long startTime = System.currentTimeMillis();
                joinPoint.proceed();
                long endTime = System.currentTimeMillis();
                executionTimeService.saveExecutionTime(joinPoint.getSignature().toString(), endTime - startTime);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return joinPoint.proceed();
    }
}
