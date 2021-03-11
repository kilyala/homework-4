package ru.geekbrains.lesson4.homework4;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
//    Это не мой код, а ваш. Я более или менее разобрался что где и почему, но мне
//    пока сложно в местах, где цикл в цикле в цикле (типа getBlockingXY). Нужно больше практики
//    с менее комплексными заданиями, чтобы пришло осознанное понимание происходящего.
    public static char[][] map;
    public static final int SIZE = 4;
    public static final int DOTS_TO_WIN = 4;

    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';

    public static Scanner sc = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        if (DOTS_TO_WIN > SIZE || DOTS_TO_WIN < 2) {
            System.err.println("Ошибка!");
        }

        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();

            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();

            if (checkWin(DOT_0)) {
                System.out.println("Победил AI");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }

        System.out.println("Game over");
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(char symb) {

        int lastIndex = map.length - 1;
        int mainDiagonal = 0;
        int sideDiagonal = 0;
        for (int i = 0; i < map.length; i++) {
            int rowCount = 0;
            int columnCount = 0;
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == symb) {
                    if (++rowCount == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    rowCount = 0;
                }

                if (map[j][i] == symb) {
                    if (++columnCount == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    columnCount = 0;
                }
            }

            mainDiagonal = getWinValue(i, i, mainDiagonal, symb);
            sideDiagonal = getWinValue(i, lastIndex - i, sideDiagonal, symb);

            if (mainDiagonal == DOTS_TO_WIN || sideDiagonal == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    public static int getWinValue(int indRow, int indCol, int value, char symb) {
        if (map[indRow][indCol] == symb) {
            return value + 1;
        }
        return 0;
    }

    public static void aiTurn() {
        int x,y;
        int[] blockingXY = getBlockingXY();
        System.out.println(Arrays.toString(blockingXY));
        if (blockingXY.length == 2) {
            y = blockingXY[0];
            x = blockingXY[1];
        } else {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));
        }

        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_0;
    }

    public static int[] getBlockingXY() {
        char symb = DOT_X;
        int mainDiagonal = 0;
        int sideDiagonal = 0;
        int lastIndex = map.length - 1;
        for (int i = 0; i < map.length; i++) {
            int rowCount = 0;
            int columnCount = 0;

            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == symb && (++rowCount + 1) == DOTS_TO_WIN) {
                    for (int l = 0; l < map.length; l++) {
                        if (isCellValid(l,i)) {
                            return new int[] {i, l};
                        }
                    }
                }

                if (map[j][i] == symb && (++columnCount + 1) == DOTS_TO_WIN) {
                    for (int l = 0; l < map.length; l++) {
                        if (isCellValid(i, l)) {
                            return new int[] {l, i};
                        }
                    }
                }
            }

            if (map[i][i] == symb && (++mainDiagonal +1) == DOTS_TO_WIN) {
                for (int l = 0; l < map.length; l++) {
                    if (isCellValid(l, l)) {
                        return new int[] {l, l};
                    }
                }
            }

            if (map[i][lastIndex - i] == symb && (++sideDiagonal + 1) == DOTS_TO_WIN) {
                for (int l = 0; l < map.length; l++) {
                    if (isCellValid(lastIndex - l, l)) {
                        return new int[] {l, lastIndex - l};
                    }
                }
            }
        }
        return new int[0];
    }
    public static void humanTurn() {
        int x,y;

        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
