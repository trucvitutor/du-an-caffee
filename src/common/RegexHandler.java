package common;

import java.util.Scanner;

public class RegexHandler {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String REGEX_PHONE = "^[0][0-9]{9}$";
    private static final String REGEX_NAME = "^[A-Z]([a-z]*)(\\s[A-Z]([a-z]*))*$";
    private static final String REGEX_CUSTOMER_CODE = "^KH-[0-9]{4}$";
    private static final String REGEX_STAFF_CODE = "^NV-[0-9]{4}$";
    private static final String REGEX_CARD = "[0-9]{12}$";
    public static String checkRegexName() {
        String value = scanner.nextLine();
        while (!String.valueOf(value).matches(REGEX_NAME)) {
            System.out.println("Enter again: ");
            value = scanner.nextLine();
        }
        return value;
    }
    public static String checkIdCard() {
        String value = scanner.nextLine();
        while (!String.valueOf(value).matches(REGEX_CARD)) {
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
    public static String checkCodeCustomer() {
        String value = scanner.nextLine();
        if (!String.valueOf(value).matches(REGEX_CUSTOMER_CODE)) {
            System.out.println("Enter again: ");
            value = scanner.nextLine();
        }

        return value;
    }
    public static String checkStaffCode() {
        String value = scanner.nextLine();
        if (!String.valueOf(value).matches(REGEX_STAFF_CODE)) {
            System.out.println("Enter again: ");
            value = scanner.nextLine();
        }

        return value;
    }


}
