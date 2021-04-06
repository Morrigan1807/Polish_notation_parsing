package ParameterizedTests.model.iterator;

public class NameRepository {

    public String[] names = {"Robert", "John", "Julie", "Lora"};

    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }

            throw new NullPointerException();
        }
    }
}