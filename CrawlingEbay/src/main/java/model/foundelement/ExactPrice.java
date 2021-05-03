package model.foundelement;

import lombok.Getter;
import lombok.Setter;

public class ExactPrice implements Price {

    @Setter
    @Getter
    private double exactPrice;

    @Override
    public boolean isWithin(double minimumPrice, double maximumPrice) {
        return exactPrice >= minimumPrice && exactPrice <= maximumPrice;
    }
}
