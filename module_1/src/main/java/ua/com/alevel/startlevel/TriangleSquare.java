package ua.com.alevel.startlevel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class TriangleSquare {

    private TriangleSquare() { }

    public static void countSquareOfTriangle() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {

                double xa, ya, xb, yb, xc, yc;

                try {
                    System.out.println("\nPlease type some dot's positions (A, B, C):");
                    System.out.print("xA = ");
                    xa = Double.parseDouble(reader.readLine());
                    System.out.print("yA = ");
                    ya = Double.parseDouble(reader.readLine());
                    System.out.print("xB = ");
                    xb = Double.parseDouble(reader.readLine());
                    System.out.print("yB = ");
                    yb = Double.parseDouble(reader.readLine());
                    System.out.print("xC = ");
                    xc = Double.parseDouble(reader.readLine());
                    System.out.print("yC = ");
                    yc = Double.parseDouble(reader.readLine());
                } catch (Exception e) {
                    System.out.println("Incorrect input data!!!");
                    continue;
                }

                double a = Math.sqrt((xa - xb) * (xa - xb) + (ya - yb) * (ya - yb));
                double b = Math.sqrt((xb - xc) * (xb - xc) + (yb - yc) * (yb - yc));
                double c = Math.sqrt((xa - xc) * (xa - xc) + (ya - yc) * (ya - yc));

                if (a + b < c || b + c < a || a + c < b) {
                    System.out.println("This triangle cannot exist!!!");
                } else {
                    double p = (a + b + c) / 2;
                    double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                    System.out.println("Answer: " + s);
                }
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
}
