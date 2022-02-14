package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class UserPanel {

    private UserPanel() {
    }

    public static void startInteract() {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String inpString = "", rez = "", rezOnlyW = "", inpSubstring = "";
            int firstIndex, lastIndex;
            char firstChar, lastChar;
            String firstString = "", lastString = "";
            while (true) {
                printMenu();
                String numOpt = bufferedReader.readLine();
                switch (numOpt) {

                    case "1" -> {
                        System.out.println("Enter your string:");
                        inpString = bufferedReader.readLine();
                        rez = StringReverseUtil.reverse(inpString);
                        rezOnlyW = StringReverseUtil.reverseOnlyWords(inpString);
                        System.out.println("Reverse string:\n" + rez);
                        System.out.println("Reverse string (only words):\n" + rezOnlyW);
                    }

                    case "2" -> {
                        System.out.println("Enter your string:");
                        inpString = bufferedReader.readLine();
                        System.out.println("Enter your substring:");
                        inpSubstring = bufferedReader.readLine();
                        rez = StringReverseUtil.reverse(inpString, inpSubstring, true);
                        rezOnlyW = StringReverseUtil.reverse(inpString, inpSubstring, false);
                        System.out.println("Reverse substring:\n" + rez);
                        System.out.println("Reverse substring (only words):\n" + rezOnlyW);
                    }

                    case "3" -> {
                        System.out.println("Enter your string:");
                        inpString = bufferedReader.readLine();
                        System.out.print("Enter first char: ");
                        firstChar = bufferedReader.readLine().charAt(0);
                        System.out.print("Enter last char: ");
                        lastChar = bufferedReader.readLine().charAt(0);
                        rez = StringReverseUtil.reverse(inpString, firstChar, lastChar, true);
                        rezOnlyW = StringReverseUtil.reverse(inpString, firstChar, lastChar, false);
                        System.out.println("Reverse substring by chars:\n" + rez);
                        System.out.println("Reverse substring by chars (only words):\n" + rezOnlyW);
                    }

                    case "4" -> {
                        System.out.println("Enter your string:");
                        inpString = bufferedReader.readLine();
                        System.out.print("Enter first index: ");
                        firstIndex = Integer.parseInt(bufferedReader.readLine());
                        System.out.print("Enter last index: ");
                        lastIndex = Integer.parseInt(bufferedReader.readLine());
                        rez = StringReverseUtil.reverse(inpString, firstIndex, lastIndex, true);
                        rezOnlyW = StringReverseUtil.reverse(inpString, firstIndex, lastIndex, false);
                        System.out.println("Reverse substring by indexes:\n" + rez);
                        System.out.println("Reverse substring by indexes (only words):\n" + rezOnlyW);
                    }

                    case "5" -> {
                        System.out.println("Enter your string:");
                        inpString = bufferedReader.readLine();
                        System.out.print("Enter first string: ");
                        firstString = bufferedReader.readLine();
                        System.out.print("Enter second string: ");
                        lastString = bufferedReader.readLine();
                        rez = StringReverseUtil.reverse(inpString, firstString, lastString, true);
                        rezOnlyW = StringReverseUtil.reverse(inpString, firstString, lastString, false);
                        System.out.println("Reverse substring by strings:\n" + rez);
                        System.out.println("Reverse substring by strings (only words):\n" + rezOnlyW);
                    }

                    case "6" -> {
                        System.exit(0);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("1. Reverse string.");
        System.out.println("2. Reverse substring.");
        System.out.println("3. Reverse substring (by chars).");
        System.out.println("4. Reverse substring (by indexes).");
        System.out.println("5. Reverse substring (by strings).");
        System.out.println("6. Exit.");
        System.out.print("-> ");
    }

}
