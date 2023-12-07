package com.nighthawk.spring_portfolio.mvc.fibonacci;

public class ForLoop extends Fibonacci {
    @Override
    protected long performCalculation(Integer num) {
        this.name = "For Loop";
        Integer endResult = 0;
        Integer prevBy2 = 0;
        Integer prevBy1 = 1;
        if (num == 0 || num == 1) {
            endResult = num;
        } else {
            for (Integer i = 1; i <= num - 1; i++){
                endResult = prevBy1 + prevBy2;
                prevBy2 = prevBy1;
                prevBy1 = endResult;
            }
        }
        return endResult;
    }
}
