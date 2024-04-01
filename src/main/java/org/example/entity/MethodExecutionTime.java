package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "method_execution_times")
public class MethodExecutionTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "method_name", nullable = false)
    private String methodName;

    @Column(name = "execution_time", nullable = false)
    private long executionTime;


    public MethodExecutionTime() {
    }


    public MethodExecutionTime(String methodName, long executionTime) {
        this.methodName = methodName;
        this.executionTime = executionTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }
}
