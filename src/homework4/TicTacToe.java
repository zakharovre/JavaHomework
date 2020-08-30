package homework4;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '•';
    private static final int SIZE = 5;
    private static final int DOT_TO_WIN = 4;
    private static final char[][] map = new char[SIZE][SIZE];
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initMap();
        showMap();
        while (true) {
            humanTurn();
            if (isWin(DOT_X)) {
                System.out.println("Победил человек!");
                break;
            }
            if (isEmptyCells()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            if (isWin(DOT_O)) {
                System.out.println("Победила машина!");
                break;
            }
            if (isEmptyCells()) {
                System.out.println("Ничья");
                break;
            }
        }

    }

    private static boolean isEmptyCells() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }

    private static boolean isWin(char symb) {
        int count;
        for (int i = 0; i < SIZE; i++) {
            count = 0;
            for (int j = 0; j < SIZE; j++) { //проверяем строки
                if (map[i][j] == symb)
                    count++;
                else
                    count = 0;
                if (count == DOT_TO_WIN)
                    return true;
            }
            count = 0;
            for (int j = 0; j < SIZE; j++) { //проверяем столбцы
                if (map[j][i] == symb)
                    count++;
                else
                    count = 0;
                if (count == DOT_TO_WIN)
                    return true;
            }
        }
        count = 0;
        for (int i = 0; i < SIZE; i++) { //проверяем главную диагональ
            if (map[i][i] == symb)
                count++;
            else
                count = 0;
            if (count == DOT_TO_WIN)
                return true;
        }
        count = 0;
        for (int i = 0; i < SIZE; i++) { //проверяем побочную диагональ
            if (map[SIZE - 1 - i][i] == symb)
                count++;
            else
                count = 0;
            if (count == DOT_TO_WIN)
                return true;
        }
        count = 0;
        for (int i = 0; i < SIZE - 1; i++) {
            if (map[i][i + 1] == symb)
                count++;
            if (count == DOT_TO_WIN)
                return true;
        }
        count = 0;
        for (int i = 0; i < SIZE - 1; i++) {
            if (map[i][SIZE - 2 - i] == symb)
                count++;
            if (count == DOT_TO_WIN)
                return true;
        }
        count = 0;
        for (int i = 1; i < SIZE; i++) {
            if (map[i][i - 1] == symb)
                count++;
            if (count == DOT_TO_WIN)
                return true;
        }
        count = 0;
        for (int i = 1; i < SIZE; i++) {
            if (map[i][SIZE - i] == symb)
                count++;
            if (count == DOT_TO_WIN)
                return true;
        }
        return false;
    }


    private static void aiTurn() {
        System.out.println("Ход компьютера:");
        int rowNum, colNum;
        do {
            rowNum = (int) (Math.random() * SIZE);
            colNum = (int) (Math.random() * SIZE);
        } while (!isCellValid(rowNum, colNum));
        map[rowNum][colNum] = DOT_O;
        showMap();
    }

    private static void humanTurn() {
        int rowNum, colNum;
        String[] turn;
        while (true) {
            System.out.print("Ход игрока в формате: 'Номер строки' 'Номер столбца': ");
            turn = scanner.nextLine().split(" ");
            if (turn.length == 2) {
                try {
                    rowNum = Integer.parseInt(turn[0]) - 1;
                    colNum = Integer.parseInt(turn[1]) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Требуется ввод чисел");
                    continue;
                }
                if (isCellValid(rowNum, colNum)) {
                    map[rowNum][colNum] = DOT_X;
                    showMap();
                    break;
                }
            }
        }
    }

    private static boolean isCellValid(int rowNum, int colNum) {
        if (rowNum >= SIZE || rowNum < 0 || colNum >= SIZE || colNum < 0)
            return false;
        return map[rowNum][colNum] == DOT_EMPTY;
    }

    private static void showMap() {
        for (int i = 0; i <= SIZE; i++)
            System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++)
            Arrays.fill(map[i], DOT_EMPTY);
    }
}

