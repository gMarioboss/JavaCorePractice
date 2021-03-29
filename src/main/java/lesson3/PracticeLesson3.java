package lesson3;

import java.util.Scanner;

public class PracticeLesson3 {
    public static Scanner in = new Scanner(System.in);
    public static final int TRIES = 3;
    public static final int RANGE = 10;

    public static void main(String[] args) {
        turnGame();
    }

    private static void turnGame() {
        int answer = generateAnswer();
        checkAnswer(answer);
    }

    private static int generateAnswer() {
        return (int) (Math.random() * RANGE);
    }

    private static void checkAnswer(int answer) {
        System.out.printf("Попробуйте отгадать число от 0 до %d%n", RANGE);

        for (int i = 1; i <= TRIES; i++) {
            int userAnswer = in.nextInt();
            if (userAnswer == answer) {
                System.out.printf("Поздравляю! Вы победили! Правильный ответ: %d%n", answer);
                break;
            } else if (i == TRIES && userAnswer != answer) {
                System.out.printf("Вы не угадали заданное число! Правильный ответ: %d%n", answer);
                break;
            } else if (userAnswer > answer) {
                System.out.printf("Ваше число слишком большое! Количество попыток %d%n", TRIES - i);
            } else if (userAnswer < answer) {
                System.out.printf("Ваше число слишком маленькое! Количество попыток %d%n", TRIES - i);
            }
        }
        exitGame();
    }

    private static void exitGame() {
        System.out.printf("Хотите попробовать еще раз? y/n%n");
        switch (in.next()) {
            case "y", "yes", "да", "+", "конечно" -> turnGame();
            default -> System.exit(0);
        }
    }
}
