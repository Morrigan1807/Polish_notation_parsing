package model.factory.creator;

import model.factory.animal.Animal;
import model.factory.animal.Mouse;

public class MouseCreator implements Creator {

    @Override
    public Animal factoryMethod() {
        return new Mouse();
    }
}
