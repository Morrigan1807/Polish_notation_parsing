package ParameterizedTests.model.factory.creator;

import ParameterizedTests.model.factory.animal.Animal;
import ParameterizedTests.model.factory.animal.Mouse;

public class MouseCreator implements Creator {

    @Override
    public Animal factoryMethod() {
        return new Mouse();
    }
}
