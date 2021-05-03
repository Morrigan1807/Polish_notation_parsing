package model.foundelement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoundedPrice implements Price {

    private double lowerPrice;
    private double upperPrice;

    @Override
    public boolean isWithin(double minimumPrice, double maximumPrice) {
        return lowerPrice <= maximumPrice || upperPrice >= minimumPrice;
    }
}
