package lesson12;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println("Два метода создали одинаковые массивы?: " + Arrays.equals(oneThread(), twoThreads()));
        System.out.println(System.currentTimeMillis() - a);
    }

    private static double[] oneThread() {
        double[] arr = new double[SIZE];
        Arrays.fill(arr, 1.0);
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = arr[i] * Math.sin(0.2 + i / 5) * Math.cos(0.2 + i / 5) * Math.cos(0.4 + i / 2);
        }
        System.out.println("Время работы первого метода: " + (System.currentTimeMillis() - a));
        return arr;
    }

    private static double[] twoThreads() {
        double[] arr = new double[SIZE];
        double[] arr1 = new double[SIZE];
        double[] arr2 = new double[SIZE];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);
        System.out.println("Время разбивки массива на 2: " + (System.currentTimeMillis() - a));

        Thread t1 = new Thread(() -> {
            long b = System.currentTimeMillis();
            for (int i = 0; i < HALF; i++) {
                arr1[i] = arr1[i] * Math.sin(0.2 + i / 5) * Math.cos(0.2 + i / 5) * Math.cos(0.4 + i / 2);
            }
            System.out.println("Время просчёта первого массива: " + (System.currentTimeMillis() - b));
        });


        Thread t2 = new Thread(() -> {
            long d = System.currentTimeMillis();
            for (int i = 0; i < HALF; i++) {
                arr2[i] = arr2[i] * Math.sin(0.2 + (HALF + i) / 5) * Math.cos(0.2 + (HALF + i) / 5) * Math.cos(0.4 + (HALF + i) / 2);
            }
            System.out.println("Время просчёта второго массива: " + (System.currentTimeMillis() - d));
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long e = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
        System.out.println("Время cклейки второго массива: " + (System.currentTimeMillis() - e));
        return arr;
    }
}

