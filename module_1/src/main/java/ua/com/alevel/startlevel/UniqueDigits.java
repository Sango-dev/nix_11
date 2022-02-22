package ua.com.alevel.startlevel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public final class UniqueDigits {

    private UniqueDigits() { }

    public static void countAmountOfUniqueDigits() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                HashSet<Integer> hashSet = new HashSet<Integer>();
                System.out.print("\nType some string: ");
                String s = reader.readLine();

                if (s.isBlank()) {
                    System.out.println("Incorrect input string!!!");
                    continue;
                }

                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        hashSet.add(Integer.valueOf(s.charAt(i)));
                    }
                }

                System.out.println("Answer: " + hashSet.size());
                System.out.print("Repeat (print 'yes') or another char to end -> ");
                s = reader.readLine();
                if (!s.equals("yes")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
