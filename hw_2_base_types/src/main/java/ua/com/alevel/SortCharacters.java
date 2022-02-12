package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class SortCharacters {

    private SortCharacters() {}

    public static void calcNumbLettersAndSort() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                System.out.print("Enter input string -> ");
                String s = bufferedReader.readLine();
                if (s == null || s.length() == 0) {
                    System.out.println("incorrect data!!!");
                    continue;
                }
                int[] mass = new int[58];
                for (int i = 0; i < s.length(); i++) {
                    char el = Character.toLowerCase(Character.toLowerCase(s.charAt(i)));
                    if (el >= 'a' && el <= 'z') {
                        mass[(int) (el) - 97]++;
                    } else if (el >= 'а' && el <= 'я') {
                        mass[(int) (el) - 1046]++;
                    }
                }

                System.out.println("Answer: ");
                int cnt = 0;
                for (int i = 0; i < 58; i++) {
                    if (mass[i] != 0) {
                        cnt++;
                        if (i < 26) {
                            System.out.println(cnt + ". " + (char) (i + 97) + " - " + mass[i]);
                        } else {
                            System.out.println(cnt + ". " + (char) (i + 1046) + " - " + mass[i]);
                        }
                    }
                }

                if (cnt == 0) {
                    System.out.println("There are no letters in the string!!!");
                }
                System.out.print("Repeat (print 'yes') or another char to end -> " );
                s = bufferedReader.readLine();
                if (!s.equals("yes")) {
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
