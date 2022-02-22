package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class EndLesson {

    private static final int VAR_1 = 1;
    private static final int VAR_2 = 2;
    private static final int VAR_5 = 5;
    private static final int VAR_9 = 9;
    private static final int VAR_10 = 10;
    private static final int VAR_15 = 15;
    private static final int VAR_45 = 45;
    private static final int VAR_60 = 60;

    private EndLesson() { }

    public static void countEndTime() {
        while(true) {
            int n;
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter the number of lessons (1...10) -> ");
                String s = bufferedReader.readLine();
                n = Integer.parseInt(s);
                if (n < VAR_1 || n > VAR_10) {
                    System.out.println("Incorrect number!!!");
                    continue;
                }
                int cur  = n * VAR_45 + (n / VAR_2) * VAR_5 + ((n + VAR_1) / VAR_2 - VAR_1) * 15;
                int h = cur / VAR_60 + VAR_9;
                int m = cur % VAR_60;
                System.out.println("Answer: ");
                System.out.println(h + " " + m);
                System.out.print("Repeat (print 'yes') or another char to end -> " );
                s = bufferedReader.readLine();
                if (!s.equals("yes")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Incorrect data!!!");
                continue;
            }
        }
    }
}
