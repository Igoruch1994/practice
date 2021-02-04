package reversestring;

import java.util.Scanner;

import static java.util.Objects.isNull;
import static util.ConsoleColor.*;
import static util.ConsoleColor.ANSI_RESET;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println(ANSI_YELLOW + "Enter number please: " + ANSI_RESET);
            final String value = new Scanner(System.in).nextLine();
            if (value.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("--------------------------------");
            final String reversedValue = reverseStringWithRecursion(value);
            //final String reversedValue = reverseStringWithIterator(value);
            System.out.println(ANSI_CYAN + "Reversed value - " + ANSI_RESET + ANSI_YELLOW + reversedValue + ANSI_RESET);
            System.out.println("--------------------------------");
        }
    }


    private static String reverseStringWithRecursion(final String value) {
        if (isNull(value) || value.isEmpty()) {
            return "";
        }
        int length = value.toCharArray().length;
        return value.charAt(length - 1) + reverseStringWithRecursion(value.substring(0, length - 1));
    }

    private static String reverseStringWithIterator(final String value) {
        final StringBuilder reversed = new StringBuilder();
        for (int i = value.length() - 1; i >= 0; i--) {
            reversed.append(value.charAt(i));
        }
        return reversed.toString();
    }
}
