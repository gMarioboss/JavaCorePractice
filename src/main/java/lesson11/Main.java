package lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        exOneTwo();
        exBig();
    }

    private static void exOneTwo() {
        Integer[] numbersArray = {1, 2};
        String[] stringsArray = {"a", "b", "c"};
        System.out.println(Arrays.toString(changeElements(numbersArray)));
        System.out.println(arrayToList(stringsArray));
    }

    private static <T> T[] changeElements(T[] array) {
        T temp = array[0];
        array[0] = array[1];
        array[1] = temp;
        return array;
    }

    private static <T> List<T> arrayToList(T[] array) {
        List<T> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, array);
        return arrayList;
    }

    private static void exBig() {
        Box<Apple> appleBox = new Box<>("Яблоки", new Apple[]{new Apple(), new Apple(),
                new Apple(), new Apple()});
        Box<Orange> orangeBox = new Box<>("Апельсины", new Orange[]{new Orange(), new Orange(),
                new Orange(), new Orange(), new Orange()});
        Box<Orange> emptyOrangeBox = new Box<>("Апельсины");

        appleBox.printInfo();
        orangeBox.printInfo();
        System.out.println("Две коробки равны?: " + appleBox.compare(orangeBox));

        orangeBox.moveToAnotherBox(emptyOrangeBox);

        orangeBox.printInfo();
        emptyOrangeBox.printInfo();
        orangeBox.addFruit(new Orange());
        orangeBox.printInfo();
    }



}
