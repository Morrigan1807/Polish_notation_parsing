package ParameterizedTests.model.factory.animal;

public class Mouse implements Animal {

    private int age;

    @Override
    public void setAge(int age) {
        this.age = age;
    }
}
