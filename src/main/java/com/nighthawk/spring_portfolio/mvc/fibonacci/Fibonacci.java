package com.nighthawk.spring_portfolio.mvc.fibonacci;

public class Fibonacci {
    protected long executionTime;
    protected String name;

    public Fibonacci() {
        this.executionTime = 0;
        this.name = "default";
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public String getName() {
        return name;
    }

    public long calculate(Integer num) {
        long startTime = System.nanoTime();
        long result = performCalculation(num);
        long endTime = System.nanoTime();
        executionTime = endTime - startTime;
        return result;
    }

    protected long performCalculation(Integer num) {
        // to be implemented by each fibonacci algorithm
        return 0;
    }
}
