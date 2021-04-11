package lesson7;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    static Cat cat1 = new Cat("Мартин");
    static Cat cat2 = new Cat("Руслана");
    static Cat cat3 = new Cat("Наоми");
    static Cat cat4 = new Cat("Том");
    static Cat[] catsArray = {cat1, cat2, cat3, cat4};

    static Plate plate1 = new Plate(40);
    static Plate plate2 = new Plate(80);
    static Plate plate3 = new Plate(50);
    static Plate plate4 = new Plate(100);
    static Plate[] platesArray = {plate1, plate2, plate3, plate4};

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            letTheCatsOut();
            printCatsInfo();
            exit();
        }
    }

    private static void letTheCatsOut() throws InterruptedException {
        while (checkIfPlatesAreEmpty() && checkIfCatsAreFed()) {
            int catNumber = (int) (Math.random() * catsArray.length);
            int plateNumber = (int) (Math.random() * platesArray.length);

            if (catsArray[catNumber].getCurrentSatiety() == catsArray[catNumber].getMaxSatiety() ||
                    !platesArray[plateNumber].isPlateEmpty()) {
                continue;
            }

            int foodValue = platesArray[plateNumber].getFood();

            platesArray[plateNumber].removeEatenFood(catsArray[catNumber], foodValue, plateNumber);
            catsArray[catNumber].eat(platesArray[plateNumber], foodValue);

            System.out.printf("%nКотик %s поел из %s миски. ", catsArray[catNumber].getName(), (plateNumber + 1));
            platesArray[plateNumber].printInfo();
            Thread.sleep(3000);
        }
    }

    private static void printCatsInfo() {
        System.out.println();
        for (Cat cat : catsArray) {
            cat.printInfo();
        }
    }

    private static boolean checkIfCatsAreFed() {
        for (Cat cat : catsArray) {
            if (cat.isCatFed()) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfPlatesAreEmpty() {
        for (Plate plate : platesArray) {
            if (plate.isPlateEmpty()) {
                return true;
            }
        }
        return false;
    }


    private static void exit() {
        if (checkIfCatsAreFed()) {
            System.out.println("\nНе все коты сыты! Укажите сколько добавить еды.");
             platesArray[(int) (Math.random() * platesArray.length)].addFood(in.nextInt());
        } else {
            System.out.println("\nВсе коты сыты и довольны!");
            System.exit(0);
        }
    }
}
