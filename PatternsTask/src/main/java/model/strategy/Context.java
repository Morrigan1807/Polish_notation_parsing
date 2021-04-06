package model.strategy;

import model.strategy.calculator.CalculatorStrategy;

public class Context {

    private CalculatorStrategy calculatorStrategy;

    public void setStrategy(CalculatorStrategy strategy) {
        this.calculatorStrategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return calculatorStrategy.calculate(a, b);
    }
}
