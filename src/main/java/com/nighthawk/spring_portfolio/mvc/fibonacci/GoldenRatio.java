package com.nighthawk.spring_portfolio.mvc.fibonacci;

public class GoldenRatio extends Fibonacci {
    @Override
    protected long performCalculation(Integer n) {
        this.name = "Golden Ratio";
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        double phiToN = Math.pow(goldenRatio, n);
        double negativePhiToMinusN = Math.pow(-goldenRatio, -n);
        double result = (phiToN - negativePhiToMinusN) / Math.sqrt(5);
        return Math.round(result);
    }
}
