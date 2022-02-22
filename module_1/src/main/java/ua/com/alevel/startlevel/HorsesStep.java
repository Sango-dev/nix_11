package ua.com.alevel.startlevel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class HorsesStep {

    private static int n;
    private static int m;
    private final static int CODE = 64;
    private final static int UPPER_BOUND = 8;
    private final static int LOWER_BOUND = 1;

    private HorsesStep() { }

    public static void doStep() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false;
        try {
            while (true) {
                if (!flag) {
                    try {
                        System.out.print("\nType start position of horse (example 'A1'): ");
                        String s = reader.readLine();
                        if (s.length() != 2) throw new Exception();
                        n = UPPER_BOUND - ((int) (s.charAt(1) - '0')) + LOWER_BOUND;
                        m = (int) (s.charAt(0) - 'A') + LOWER_BOUND;
                        if (n < LOWER_BOUND || n > UPPER_BOUND || m < LOWER_BOUND || m > UPPER_BOUND) {
                            System.out.println("Incorrect input position!!!");
                            continue;
                        }
                        buildTable(n, m);
                    } catch (Exception e) {
                        System.out.println("Incorrect input data!!!");
                        continue;
                    }
                    flag = true;
                }

                try {
                    System.out.print("\nType next position of horse (example 'B3'): ");
                    String s = reader.readLine();
                    if (s.length() != 2) throw new Exception();
                    int r = UPPER_BOUND - ((int) (s.charAt(1) - '0')) + LOWER_BOUND;
                    int c = (int) (s.charAt(0) - 'A') + LOWER_BOUND;
                    if (r < LOWER_BOUND || r > UPPER_BOUND || c < LOWER_BOUND || c > UPPER_BOUND) {
                        System.out.println("Incorrect input position!!!");
                        continue;
                    }
                    checkCorrectStep(reader, r, c);
                } catch (Exception e) {
                    System.out.println("Incorrect input data!!!");
                    continue;
                }

                System.out.println();
                System.out.println("* Continue making horse's step from this position, please type '1'.");
                System.out.println("* If you want to restart program, please type '2'.");
                System.out.println("* Finish program, please type some char.");
                System.out.print("-> ");
                String s = reader.readLine();
                if (s.equals("1")) {
                    flag = true;
                    continue;
                } else if (s.equals("2")) {
                    flag = false;
                    continue;
                }
                break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkCorrectStep(BufferedReader reader, int r, int c) {
        int ansN = Math.abs(r - n);
        int ansM = Math.abs(c - m);
        if ((ansN == 1 && ansM == 2) || (ansN == 2 && ansM == 1)) {
            buildTable(r, c);
            n = r;
            m = c;
        } else {
            System.out.println("Step is impossible!!!");
        }
    }

    public static void buildTable(int n, int m) {
        System.out.println();
        for (int i = 1; i <= 8; i++) {
            System.out.print("    ");
            for (int j = 1; j <= 8; j++) {
                if (j == 1) System.out.print("-----");
                else System.out.print("----");
            }
            System.out.println();
            System.out.print("  " + (UPPER_BOUND - i + LOWER_BOUND) + " ");
            for (int j = 1; j <= 8; j++) {
                if (j == m && i == n && j == 1) {
                    System.out.print("| K |");
                } else if (j == m && i == n) {
                    System.out.print(" K |");
                } else if (j == 1) System.out.print("|   |");
                else System.out.print("   |");
            }
            System.out.println();
            if (i == 8) {
                System.out.print("    ");
                for (int j = 1; j <= 8; j++) {
                    if (j == 1) System.out.print("-----");
                    else System.out.print("----");
                }
                System.out.print("\n      ");
                for (int j = 1; j <= 8; j++) {
                    System.out.print((char) (CODE + j) + "   ");
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}