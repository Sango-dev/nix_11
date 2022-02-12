package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public final class SumDigits {
    private SumDigits() {}

    public static void calcSumDigits() {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int ans = 0;
            while(true) {
                System.out.print("Enter input string -> ");
                String s = bufferedReader.readLine();
                if (s == null || s.length() == 0) {
                    System.out.println("incorrect data!!!");
                    continue;
                }
                for (int i = 0; i < s.length(); i++ ) {
                    if (s.charAt(i) > '0' && s.charAt(i) <= '9') {
                        ans += (int) (s.charAt(i) - '0');
                    }
                }
                System.out.println("sum = " + ans);
                System.out.print("Repeat (print 'yes') or another char to end -> " );
                s = bufferedReader.readLine();
                if (s.equals("yes")) {
                    ans = 0;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
