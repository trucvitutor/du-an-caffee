package common;

import java.util.Scanner;

public class ExceptionHandler {
    private static final Scanner scanner = new Scanner(System.in);
    public static int checkForParseInt(String name) {
        int value;
        while (true) {
            try {
                System.out.print("Nhập " + name + ": ");
                value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (Exception exception) {
                System.out.println("Hãy nhập số!!");
            }
        }
    }

    public static double checkParseDouble() {
        double value;
        while (true) {
            try {
                value = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format");
                System.out.print("Try again: ");
            }
        }
        return value;
    }

}
