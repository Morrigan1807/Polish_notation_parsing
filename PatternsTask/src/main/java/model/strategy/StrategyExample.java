package model.strategy;

import model.strategy.calculator.AddStrategy;

public class StrategyExample {
    public int addStrategyExample() {
        Context context = new Context();

        context.setStrategy(new AddStrategy());

        return context.executeStrategy(3, 4);
    }
}
