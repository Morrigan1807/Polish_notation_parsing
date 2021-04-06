package ParameterizedTests.model.strategy.calculator;

public class AddStrategy implements CalculatorStrategy {

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
