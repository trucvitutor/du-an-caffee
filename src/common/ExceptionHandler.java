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
    public static int checkParseInteger() {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Sai định dạng, nhập lại:");
            }
        }
        return value;
    }
}
