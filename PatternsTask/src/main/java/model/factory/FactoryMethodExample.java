package model.factory;

import model.factory.animal.Animal;
import model.factory.creator.Creator;
import model.factory.creator.MouseCreator;
import model.factory.creator.RaccoonCreator;

public class FactoryMethodExample {
    public void factoryMethodExample() {
        Creator[] creators = {new MouseCreator(), new RaccoonCreator()};

        for (Creator creator : creators) {
            Animal animal = creator.factoryMethod();
            animal.setAge(1);
        }
    }
}
