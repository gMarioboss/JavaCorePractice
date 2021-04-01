package lesson4;

import java.util.Scanner;

public class PracticeLesson4 {
    static Scanner in = new Scanner(System.in);

    static int row = -1;
    static int column = -1;
    static int chips = 3;

    static int turnCount = 0;
    static final char HEADER_EMPTY_POS = '♥';
    static final String EMPTY = " ";

    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';
    static final char DOT_EMPTY = '•';

    static final int SIZE = 5;
    static final char[][] MAP = new char[SIZE][SIZE];


    public static void main(String[] args) {
        turnGame();
    }

    private static void turnGame() {
        do {
            intMap();

            printMap();

            playGame();

            exitGame();
        } while (true);
    }

    private static void intMap() {
        turnCount = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }

    }

    private static void printMap() {
        printHeaderMap();

        printMainMap();

    }

    private static void printHeaderMap() {
        System.out.print(HEADER_EMPTY_POS + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printRowsAndColumns(i);
        }
        System.out.println();
    }

    private static void printMainMap() {
        for (int i = 0; i < SIZE; i++) {
            printRowsAndColumns(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + EMPTY);
            }
            System.out.println();
        }
    }

    private static void printRowsAndColumns(int i) {
        System.out.print(i + 1 + EMPTY);
    }


    private static void playGame() {
        do {
            humanTurn();
            printMap();
            if (checkEnd(DOT_HUMAN)) {
                break;
            }
            aiTurn();
            printMap();
            if (checkEnd(DOT_AI)) {
                break;
            }
        } while (true);
    }

    private static boolean checkEnd(char symbol) {
        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Поздравляю, Вы победили!");
            } else {
                System.out.println("К сожалению машина оказалась победителем!");
            }
            return true;
        } else if (isMapFull()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static boolean checkWin(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            if (checkLine(i, 0, 0, 1, symbol)) {
                return true;
            }

            if (checkLine(0, i, 1, 0, symbol)) {
                return true;
            }
        }
        if (checkMainDiagonals(SIZE - 1, symbol)) {
            return true;
        }
        if (checkRevertedDiagonals(SIZE - 1, symbol)) {
            return true;
        }

        return false;

    }

    public static boolean checkLine(int x, int y, int dx, int dy, char symbol) {
        int winCountLine = 0;
        for (int i = 0; i < SIZE; i++) {
            if (MAP[x + i * dx][y + i * dy] != symbol) {
                winCountLine = 0;
                continue;
            }
            winCountLine++;
            if (checkWinStreak(winCountLine)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkMainDiagonals(int iterations, char symbol) {
        int winCountMain = 0;
        int winCountSide = 0;

        int var = 0;
        for (int i = 0; i < SIZE; i++) {
            if (MAP[i][i] != symbol) {
                winCountMain = 0;
            } else {
                winCountMain++;
            }
            if (checkWinStreak(winCountMain)) {
                return true;
            }

            var = i;
            for (int j = 0; j < iterations && i < chips - 1; j++) {
                if (MAP[j][var++ + 1] != symbol) {
                    winCountSide = 0;
                    continue;
                }
                winCountSide++;
                if (checkWinStreak(winCountSide)) {
                    return true;
                }
            }
            var = i;
            for (int j = 0; j < iterations && i < chips - 1; j++) {
                if (MAP[var++ + 1][j] != symbol) {
                    winCountSide = 0;
                    continue;
                }
                winCountSide++;
                if (checkWinStreak(winCountSide)) {
                    return true;
                }
            }
            winCountSide = 0;
            iterations--;
        }

        return false;
    }

    private static boolean checkRevertedDiagonals(int iterations, char symbol) {
        int winCountMain = 0;
        int winCountSide = 0;

        for (int i = 0; i < SIZE; i++) {
            if (MAP[(SIZE - 1) - i][i] != symbol) {
                winCountMain = 0;
            } else {
                winCountMain++;
            }
            if (checkWinStreak(winCountMain)) {
                return true;
            }

            for (int j = 0; j < iterations && chips > i + 1; j++) {
                if (MAP[(SIZE - 1) - (i + j + 1)][j] != symbol) {
                    winCountSide = 0;
                    continue;
                }
                winCountSide++;
                if (checkWinStreak(winCountSide)) {
                    return true;
                }
            }

            for (int j = 0; j < iterations && chips > i + 1; j++) {
                if (MAP[(SIZE - 1) - j][(j + i) + 1] != symbol) {
                    winCountSide = 0;
                    continue;
                }
                winCountSide++;
                if (checkWinStreak(winCountSide)) {
                    return true;
                }
            }
            winCountSide = 0;
            iterations--;
        }
        return false;
    }

    private static boolean checkWinStreak(int winStreak) {
        return winStreak == chips;
    }

    private static boolean isMapFull() {
        return turnCount == SIZE * SIZE;
    }

    private static void humanTurn() {
        System.out.println("Введите ваш ход:");
        boolean isInputCorrect = true;

        do {
            System.out.print("Строка: ");
            if (in.hasNextInt()) {
                row = in.nextInt() - 1;
            } else {
                printIncorrectInput();
                in.next();
                isInputCorrect = false;
                continue;
            }

            System.out.print("Столбец: ");
            if (in.hasNextInt()) {
                column = in.nextInt() - 1;
            } else {
                printIncorrectInput();
                in.next();
                isInputCorrect = false;
            }
        } while (!(isInputCorrect && isHumanInputValid(row, column)));

        MAP[row][column] = DOT_HUMAN;
        turnCount++;
    }

    private static void aiTurn() {
        boolean aiWin = false;
        boolean humanWin = false;

        System.out.println("Ход компьютера: ");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                if (isCellFree(i, j)) {
                    MAP[i][j] = DOT_HUMAN;

                    if (checkWin(DOT_HUMAN)) {
                        row = i;
                        column = j;
                        humanWin = true;
                    }
                    MAP[i][j] = DOT_EMPTY;
                }
            }
        }

        if (!humanWin) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {

                    if (isCellFree(i, j)) {
                        MAP[i][j] = DOT_AI;

                        if (checkWin(DOT_AI)) {
                            row = i;
                            column = j;
                            aiWin = true;
                        }
                        MAP[i][j] = DOT_EMPTY;
                    }
                }
            }
        }

        if (!aiWin && !humanWin) {
            do {
                row = (int) (Math.random() * SIZE);
                column = (int) (Math.random() * SIZE);
            }
            while (!isCellFree(row, column));
        }
        MAP[row][column] = DOT_AI;
        turnCount++;
    }


    private static void printIncorrectInput() {
        System.out.println("Вы ввели не корректное значение! Введите число в диапазоне поля");
    }

    private static boolean isHumanInputValid(int inputRow, int inputColumn) {
        if (!isNumberValid(inputRow, inputColumn)) {
            System.out.println("Проверьте правильность ввода строки и колонки!");
            return false;
        } else if (!isCellFree(inputRow, inputColumn)) {
            System.out.println("Ваша ячейка уже занята!");
            return false;
        }
        return true;
    }

    private static boolean isNumberValid(int inputRow, int inputColumn) {
        return inputRow >= 0 && inputRow < SIZE && inputColumn >= 0 && inputColumn < SIZE;
    }

    private static boolean isCellFree(int inputRow, int inputColumn) {
        return MAP[inputRow][inputColumn] == DOT_EMPTY;
    }

    private static void exitGame() {
        System.out.println("Хотите попробовать еще раз? y/n");
        switch (in.next()) {
            case "n", "no", "нет", "НЕТ" -> System.exit(0);
        }
    }
}