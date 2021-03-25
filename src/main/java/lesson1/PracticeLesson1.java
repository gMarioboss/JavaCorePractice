package lesson1;

public class PracticeLesson1 {
    public static void main(String[] args) {

        //ex1
        byte aByte = 0;

        short aShort = 1000;
        int aInt = 5;
        long aLong = 1815851L;

        float aFloat = 54.36f;
        double aDouble = 51.87;

        char aChar = 751, aChar2 = '$';
        boolean aBoolean = true;

        String aString = "Hello, World!";

        ex2();
        ex3();
        ex4();
        ex5();
        ex6();
        ex7();
    }

    private static void ex2() {
        System.out.println("Result = " + calculateExpression(5, 3.5, 10.2,4));
    }

    private static double calculateExpression(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    private static void ex3() {
        System.out.println("Р’Р°С€Р° СЃСѓРјРјР° Р»РµР¶РёС‚ РІ РїСЂРµРґРµР»Р°С… РѕС‚ 10 РґРѕ 20? - " + checkSum(7,5));
    }

    private static boolean checkSum(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    private static void ex4() {
        positiveOrNegative(35);
    }

    private static void positiveOrNegative(int a) {
        if (a > 0 || a == 0)
            System.out.println("Р§РёСЃР»Рѕ " + a + " - РїРѕР»РѕР¶РёС‚РµР»СЊРЅРѕРµ.");
        else System.out.println("Р§РёСЃР»Рѕ " + a + " - РѕС‚СЂРёС†Р°С‚РµР»СЊРЅРѕРµ.");
    }

    private static void ex5() {
        System.out.println(booleanPositiveOrNegative(-5));
    }

    private static boolean booleanPositiveOrNegative(int a) {
        return !(a > 0 || a == 0);
    }

    private static void ex6() {
        helloName("Р•РІРіРµРЅРёР№");
    }

    private static void helloName(String name) {
        System.out.println("РџСЂРёРІРµС‚, " + name + "!");
    }

    private static void ex7() {
        checkLeapYear(88);
    }

    private static void checkLeapYear(int a) {
        if ((a % 4 == 0 && a / 100 < 4) || (a % 4 == 0 && a / 100 > 4) || (a % 4 == 0 && a % 400 == 0))
            System.out.println("Р“РѕРґ " + a + " СЏРІР»СЏРµС‚СЃСЏ РІРёСЃРѕРєРѕСЃРЅС‹Рј");
        else System.out.println("Р“РѕРґ " + a + " СЏРІР»СЏРµС‚СЃСЏ РЅРµРІРёСЃРѕРєРѕСЃРЅС‹Рј");
    }
}
