package lesson2;

import java.util.Arrays;

public class PracticeLesson2 {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
        ex6();
        ex7();
    }

    private static void ex1() {
        byte[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(changeNumber(array)));
    }

    private static byte[] changeNumber(byte[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        return array;
    }

    private static void ex2() {
        int[] array = new int[8];
        System.out.println(Arrays.toString(fillNumbers(array)));
    }

    private static int[] fillNumbers(int[] array) {
        int plus = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] += plus;
            plus += 3;
        }
        return array;
    }

    private static void ex3() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(multiplyNumbers(array)));
    }

    private static int[] multiplyNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        return array;
    }

    private static void ex4() {
        final int SIZE = 10;
        int[][] array = new int[SIZE][SIZE];
        fillDiagonals(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%3d", array[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] fillDiagonals(int[][] array) {
        int n = array.length;
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][--n] = 1;
        }
        return array;
    }

    private static void ex5() {
        int[] array = {5, 12, 15, 7, 3, 9, 4};
        System.out.println("Массив: " + Arrays.toString(array) + "\n Максимальный элемент = " + maxElementSort(array) +
                "\n Минимальный элемент = " + minElementSort(array));

        //Альтернативный вариант
        int maxElement = array[0];
        int minElement = array[0];
        for (int i = 0; i < array.length; i++) {
            if (maxElement < array[i]) {
                maxElement = array[i];
            } else if (minElement > array[i]) {
                minElement = array[i];
            }
        }
        System.out.println("\nМассив: " + Arrays.toString(array) + "\n Максимальный элемент = " + maxElement +
                "\n Минимальный элемент = " + minElement);

    }

    private static int minElementSort(int[] array) {
        Arrays.sort(array);
        return array[0];

    }

    private static int maxElementSort(int[] array) {
        Arrays.sort(array);
        return array[array.length - 1];

    }

    private static void ex6() {
        int[] array = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println("\nЕсть ли место в массиве " + Arrays.toString(array) +
                " где сумма обеих частей равна? - " + checkBalance(array));
    }

    private static boolean checkBalance(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int halfSum = 0;
        for (int i = 0; i < array.length; i++) {
            halfSum += array[i];
            if (halfSum == sum / 2) {
                return true;
            }
        }
        return false;
    }

    private static void ex7() {
        int[] array = {1, 2, 3, 4, 5};
        final int STEP = -2;

        if (STEP > 0) {
            System.out.println("\nМассив " + Arrays.toString(array) +
                    " с шагом " + STEP + " вправо будет иметь вид: " +
                    Arrays.toString(changePositionsRight(array, STEP)));
        } else {
            System.out.println("\nМассив " + Arrays.toString(array) +
                    " с шагом " + STEP + " влево будет иметь вид: " +
                    Arrays.toString(changePositionsLeft(array, STEP)));
        }
    }

    private static int[] changePositionsRight(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int saveNumber = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = saveNumber;
        }
        return array;
    }

    private static int[] changePositionsLeft(int[] array, int n) {
        int step = -n;
        for (int i = 0; i < step; i++) {
            int saveNumber = array[0];
            for (int j = 0; j < array.length-1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = saveNumber;
        }
        return array;
    }
}