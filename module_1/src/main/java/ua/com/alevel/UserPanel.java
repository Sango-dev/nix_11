package ua.com.alevel;

import ua.com.alevel.hardlevel.GameLife;
import ua.com.alevel.mediumlevel.BracketSequence;
import ua.com.alevel.startlevel.HorsesStep;
import ua.com.alevel.startlevel.TriangleSquare;
import ua.com.alevel.startlevel.UniqueDigits;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class UserPanel {
    private UserPanel() {
    }

    public static void startInteract() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String opt = "";
            while (true) {
                printMenu();
                opt = reader.readLine();
                doAction(opt);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void printMenu() {

        System.out.print("""
                               
                Select a task:
                1. Count amount of unique digits.
                2. Check horse's move. 
                3. Count square of triangle.
                4. Сheck bracket sequence.
                5. Game of life.
                0. Exit.""" + "\n-> ");
    }

    public static void doAction(String opt) {
        switch (opt) {
            case "1" -> UniqueDigits.countAmountOfUniqueDigits();
            case "2" -> HorsesStep.doStep();
            case "3" -> TriangleSquare.countSquareOfTriangle();
            case "4" -> BracketSequence.checkBracketSequence();
            case "5" -> GameLife.runGameLife();
            case "0" -> System.exit(0);
            default -> System.out.println("Incorrect input data!!!");
        }
    }
}
