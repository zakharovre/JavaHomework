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
        int count;
        for (int i = 0; i < SIZE; i++) {
            count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_X) {
                    count++;
                    if (count == 2) {
                        if (j + 2 < SIZE) {
                            if (map[i][j + 1] == DOT_EMPTY && map[i][j + 2] == DOT_X) {
                                map[i][j + 1] = DOT_O;
                                showMap();
                                return;
                            }
                        }
                        if (j - 3 >= 0) {
                            if (map[i][j - 2] == DOT_EMPTY && map[i][j - 3] == DOT_X) {
                                map[i][j - 2] = DOT_O;
                                showMap();
                                return;
                            }
                        }
                    }
                    if (count == 3) {
                        if (isCellValid(i, j + 1)) {
                            map[i][j + 1] = DOT_O;
                            showMap();
                            return;
                        } else if (isCellValid(i, j - 3)) {
                            map[i][j - 3] = DOT_O;
                            showMap();
                            return;
                        }
                    }
                } else
                    count = 0;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == DOT_X) {
                    count++;
                    if (count == 2) {
                        if (j + 2 < SIZE) {
                            if (map[j + 1][i] == DOT_EMPTY && map[j + 2][i] == DOT_X) {
                                map[j + 1][i] = DOT_O;
                                showMap();
                                return;
                            }
                        }
                        if (j - 3 >= 0) {
                            if (map[j - 2][i] == DOT_EMPTY && map[j - 3][i] == DOT_X) {
                                map[j - 2][i] = DOT_O;
                                showMap();
                                return;
                            }
                        }
                    }
                    if (count == 3) {
                        if (isCellValid(j + 1, i)) {
                            map[j + 1][i] = DOT_O;
                            showMap();
                            return;
                        } else if (isCellValid(j - 3, i)) {
                            map[j - 3][i] = DOT_O;
                            showMap();
                            return;
                        }
                    }
                } else
                    count = 0;
            }
        }
        count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == DOT_X) {
                count++;
                if (count == 2) {
                    if (i + 2 < SIZE) {
                        if (map[i + 1][i + 1] == DOT_EMPTY && map[i + 2][i + 2] == DOT_X) {
                            map[i + 1][i + 1] = DOT_O;
                            showMap();
                            return;
                        }
                    }
                    if (i - 3 >= 0) {
                        if (map[i - 2][i - 2] == DOT_EMPTY && map[i - 3][i - 3] == DOT_X) {
                            map[i - 2][i - 2] = DOT_O;
                            showMap();
                            return;
                        }
                    }
                }
                if (count == 3) {
                    if (isCellValid(i + 1, i + 1)) {
                        map[i + 1][i + 1] = DOT_O;
                        showMap();
                        return;
                    } else if (isCellValid(i - 3, i - 3)) {
                        map[i - 3][i - 3] = DOT_O;
                        showMap();
                        return;
                    }
                }
            } else
                count = 0;
        }
        count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][SIZE-1-i] == DOT_X) {
                count++;
                if (count == 2) {
                    if (i + 2 < SIZE) {
                        if (map[i + 1][SIZE-2-i] == DOT_EMPTY && map[i + 2][SIZE-2-i] == DOT_X) {
                            map[i + 1][SIZE-2-i] = DOT_O;
                            showMap();
                            return;
                        }
                    }
                    if (i - 3 >= 0) {
                        if (map[i - 2][SIZE+1-i] == DOT_EMPTY && map[i - 3][SIZE+2-i] == DOT_X) {
                            map[i - 2][SIZE+1-i] = DOT_O;
                            showMap();
                            return;
                        }
                    }
                }
                if (count == 3) {
                    if (isCellValid(i + 1, SIZE-2-i)) {
                        map[i + 1][SIZE-2-i] = DOT_O;
                        showMap();
                        return;
                    } else if (isCellValid(i - 3, SIZE+2-i)) {
                        map[i - 3][SIZE+2-i] = DOT_O;
                        showMap();
                        return;
                    }
                }
            } else
                count = 0;
        }
        randTurn();
    }

    private static void randTurn() {
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
