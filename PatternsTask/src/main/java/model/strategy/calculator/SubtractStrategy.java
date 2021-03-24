package model.strategy.calculator;

public class SubtractStrategy implements CalculatorStrategy {

    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}
