package lesson11;

public interface Storage<E extends Fruit> {
    void addFruit(E fruit);
    double getBoxWeight();
    boolean compare(Box<?> box);
    void moveToAnotherBox(Box<E> box);
}
