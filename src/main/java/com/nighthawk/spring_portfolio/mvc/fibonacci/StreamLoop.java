package com.nighthawk.spring_portfolio.mvc.fibonacci;

import java.util.stream.Stream;

public class StreamLoop extends Fibonacci {
    @Override
    protected long performCalculation(Integer num) {
        this.name = "Stream Loop";
        return Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                .limit(num + 1)
                .mapToInt(fib -> fib[0])
                .skip(num)
                .findFirst()
                .orElseThrow(); // won't happen for non-negative n
    }
}
