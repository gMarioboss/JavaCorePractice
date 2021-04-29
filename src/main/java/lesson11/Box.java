package lesson11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box <E extends Fruit> implements Storage<E>{
    String name;
    List<E> boxStorage = new ArrayList<>();

    public Box(String name, E[] fruitArray) {
        Collections.addAll(this.boxStorage, fruitArray);
        this.name = name;
    }

    public Box (String name) {
        this.boxStorage = new ArrayList<>();
        this.name = name;
    }

    public void addFruit(E fruit) {
        boxStorage.add(fruit);
    }

    public double getBoxWeight() {
        double sum = 0.0;
        for (int i = 0; i < boxStorage.size(); i++) {
            sum += boxStorage.get(i).getWeight();
        }
        return sum;

    }

    public boolean compare(Box<?> box) {
        return getBoxWeight() == box.getBoxWeight();
    }

    public void moveToAnotherBox(Box<E> box) {
        for (E fruit : boxStorage) {
            box.addFruit(fruit);
        }
        this.boxStorage.clear();
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("Коробка %s весит %.1f", name, getBoxWeight());
    }

}
