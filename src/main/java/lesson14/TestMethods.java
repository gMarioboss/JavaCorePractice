package lesson14;

import java.util.Arrays;

public class TestMethods {
    public static void main(String[] args) {

    }

    public static int[] findNumbers(int[] array) {
        try {
            if (checkIfArrayCorrect(array, 4)) {
                throw new RuntimeException("В заданном массиве нет значения 4");
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            throw e;
        }

        int lastValue = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                lastValue = i + 1;
            }
        }
        int[] newArray = new int[array.length - lastValue];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[lastValue + i];
        }
        return newArray;
    }

    private static boolean checkIfArrayCorrect(int[] array, int number) {
        int[] arrayTest = Arrays.copyOf(array, array.length);
        Arrays.sort(arrayTest);
        int a = Arrays.binarySearch(arrayTest, number);
        if (a < 0) {
            return true;
        }
        return false;
    }

    public static boolean checkNumbers(int[] array) {
        if (checkIfArrayCorrect(array, 1) || checkIfArrayCorrect(array, 4)) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 1 && array[i] != 4) {
                return false;
            }
        }
        return true;
    }

}
