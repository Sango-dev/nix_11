package ua.com.alevel.hardlevel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class GameLife {

    private static int w;
    private static int l;
    private static int[][] field;

    private GameLife() { }

    public static void runGameLife() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                try {
                    System.out.println("\nType some bounds of field:");
                    System.out.print("Amount of rows: ");
                    l = Integer.parseInt(reader.readLine());
                    System.out.print("Amount of cols: ");
                    w = Integer.parseInt(reader.readLine());
                } catch (Exception e) {
                    System.out.println("Incorrect input data!!!");
                    continue;
                }

                if (w <= 0 || l <= 0) {
                    System.out.println("Input boundaries are not valid!!!");
                    continue;
                }

                field = new int[w][l];
                int kolAlive = (int) (Math.random() * w * l / 4) + (w * l / 2);

                for (int i = 0; i < kolAlive; i++) {
                    setAlive((int) (Math.random() * w), (int) (Math.random() * l));
                }

                System.out.println("\nStart field (# - alive cell):\n");
                printField();
                for (int i = 0; i < w * l; i++) {
                    step();
                }
                System.out.println("\nEnd field (# - alive cell):\n");
                printField();

                System.out.print("\nRepeat (print 'yes') or another char to end -> ");
                String s = reader.readLine();
                if (!s.equals("yes")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printField() {
        System.out.println("*******");
        for (int j = 0; j < l; j++) {
            String s = "|";
            for (int i = 0; i < w; i++) {
                if (field[i][j] == 0) {
                    s += ".";
                } else {
                    s += "#";
                }
            }
            s += "|";
            System.out.println(s);
        }
        System.out.println("*******\n");
    }

    private static void setAlive(int x, int y) {
        field[x][y] = 1;
    }

    private static int cntAliveNeighbours(int x, int y) {
        int cnt = 0;
        cnt += isAlive(x - 1, y + 1);
        cnt += isAlive(x, y + 1);
        cnt += isAlive(x + 1, y + 1);
        cnt += isAlive(x - 1, y - 1);
        cnt += isAlive(x, y - 1);
        cnt += isAlive(x + 1, y - 1);
        cnt += isAlive(x - 1, y);
        cnt += isAlive(x + 1, y);
        return cnt;
    }

    private static void step() {
        int[][] newField = new int[w][l];
        for (int j = 0; j < l; j++) {
            for (int i = 0; i < w; i++) {
                int aliveNeighbours = cntAliveNeighbours(i, j);
                if (isAlive(i, j) == 1) {
                    if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                        newField[i][j] = 0;
                    } else {
                        newField[i][j] = 1;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        newField[i][j] = 1;
                    }
                }
            }
        }
        field = newField;
    }

    private static int isAlive(int x, int y) {
        if (x < 0 || x >= w) {
            return 0;
        }
        if (y < 0 || y >= l) {
            return 0;
        }
        return field[x][y];
    }
}