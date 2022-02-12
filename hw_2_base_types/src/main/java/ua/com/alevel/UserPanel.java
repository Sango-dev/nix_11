package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class UserPanel {

    private UserPanel() {}

    public static void startInteract() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while(true) {
                printMenu();
                String numOpt = bufferedReader.readLine();
                switch(numOpt) {
                    case "1":
                        SumDigits.calcSumDigits();
                        break;
                    case "2":
                        SortCharacters.calcNumbLettersAndSort();
                        break;
                    case "3":
                        EndLesson.countEndTime();
                        break;
                    case "4":
                        System.exit(0);
                        break;
                    default:
                        break;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("1. Sum of numbers.");
        System.out.println("2. Sort characters.");
        System.out.println("3. Calculate end time of lessons.");
        System.out.println("4. Exit.");
        System.out.print("-> ");
    }
}
