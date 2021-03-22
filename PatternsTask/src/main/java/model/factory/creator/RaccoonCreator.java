package model.factory.creator;

import model.factory.animal.Animal;
import model.factory.animal.Raccoon;

public class RaccoonCreator implements Creator {
    @Override
    public Animal factoryMethod() {
        return new Raccoon();
    }
}
