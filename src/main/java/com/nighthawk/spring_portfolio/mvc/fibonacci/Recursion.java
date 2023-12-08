package com.nighthawk.spring_portfolio.mvc.fibonacci;

public class Recursion extends Fibonacci {
    @Override
    protected long performCalculation(Integer num) {
        this.name = "Recursion";
        return recur(num);
    }
    
    private long recur(Integer num) {
        if (num <= 1) {
            return (long) num; // base case where 0 is 0 and 1 is 1
        } else {
            // recursion case
            return recur(num - 1) + recur(num - 2);
        }
    }
}