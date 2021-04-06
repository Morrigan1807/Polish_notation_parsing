package ParameterizedTests.model.factory.creator;

import ParameterizedTests.model.factory.animal.Animal;
import ParameterizedTests.model.factory.animal.Raccoon;

public class RaccoonCreator implements Creator {

    @Override
    public Animal factoryMethod() {
        return new Raccoon();
    }
}
