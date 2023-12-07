package com.nighthawk.spring_portfolio.mvc.fibonacci;

public class WhileLoop extends Fibonacci {
    @Override
    protected long performCalculation(Integer num) {
        this.name = "While Loop";
        Integer endResult = 0;
        Integer prevBy2 = 0;
        Integer prevBy1 = 1;
        if (num == 0 || num == 1){
            endResult = num;
        } else {
            Integer i = 1;
            do {
                endResult = prevBy1 + prevBy2;
                prevBy2 = prevBy1;
                prevBy1 = endResult;
                i = i + 1;
            } while(i <= num - 1);
        }
        return endResult;
    }
}