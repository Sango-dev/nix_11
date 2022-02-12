package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class EndLesson {

    private EndLesson() { }

    public static void countEndTime() {
        while(true) {
            int n;
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter the number of lessons (1...10) -> ");
                String s = bufferedReader.readLine();
                n = Integer.parseInt(s);
                if (n < 1 || n > 10) {
                    System.out.println("Incorrect number!!!");
                    continue;
                }
                int cur  = n * 45 + (n / 2) * 5 + ((n + 1) / 2 - 1) * 15;
                int h = cur / 60 + 9;
                int m = cur % 60;
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
