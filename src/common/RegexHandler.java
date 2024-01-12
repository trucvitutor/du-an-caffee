package common;

import java.util.Scanner;

public class RegexHandler {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String REGEX_PHONE = "^[0][0-9]{9}$";
    private static final String REGEX_NAME = "^[A-Z]([a-z]*)(\\s[A-Z]([a-z]*))*$";
    public static String checkRegexName() {
        String value = scanner.nextLine();
        while (!String.valueOf(value).matches(REGEX_NAME)) {
            System.out.println("Enter again: ");
            value = scanner.nextLine();
        }
        return value;
    }
    public static String checkPhoneNumber() {
        String value = scanner.nextLine();
        while (!String.valueOf(value).matches(REGEX_PHONE)) {
            System.out.println("Enter again: ");
            value = scanner.nextLine();
        }
        return value;
    }


}
