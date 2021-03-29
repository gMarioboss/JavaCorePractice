package lesson3;

import java.util.Scanner;

public class PracticeLesson3_1 {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        turnGame();
    }

    private static void turnGame() {
        String answer = generateAnswer();
        checkAnswer(answer);
    }

    private static String generateAnswer() {
        String[] wordsArray = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        return wordsArray[(int)(Math.random() * wordsArray.length)];
    }

    private static void checkAnswer(String answer) {
        System.out.println("Попробуйте отгадать загаданное слово. Подсказка: фрукт или овощь.");
        StringBuilder currentAnswer = new StringBuilder("################");

        while (true) {
            String userAnswer = in.next();
            int charAmount = Math.min(userAnswer.length(), answer.length());
            for (int i = 0; i < charAmount-1; i++) {
                if (userAnswer.equals(answer)) {
                    exitGame(answer);
                } else if (userAnswer.charAt(i) == answer.charAt(i)) {
                    currentAnswer.setCharAt(i, userAnswer.charAt(i));
                }
            }
            System.out.printf("Ваш ответ на данный момент: %s. Попробуйте еще раз%n", currentAnswer);
        }
    }

    private static void exitGame(String answer) {
        System.out.printf("Поздравляю! Вы угадали. Правильный ответ: %s%nХотите попробовать еще раз? y/n%n", answer);
        switch (in.next()) {
            case "y", "yes", "да", "+", "конечно" -> turnGame();
            default -> System.exit(0);
        }
    }
}

