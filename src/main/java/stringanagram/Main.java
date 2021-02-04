package stringanagram;

import java.util.Scanner;

import static java.util.Objects.isNull;
import static util.ConsoleColor.*;
import static util.ConsoleColor.ANSI_RESET;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println(ANSI_YELLOW + "Enter first word please: " + ANSI_RESET);
            final String firstValue = new Scanner(System.in).nextLine();
            if (firstValue.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println(ANSI_YELLOW + "Enter second word please: " + ANSI_RESET);
            final String secondValue = new Scanner(System.in).nextLine();
            System.out.println("--------------------------------");
            final boolean areAnagram = areStringsAnagram(firstValue, secondValue);
            System.out.println(ANSI_CYAN + "Anagram ? - " + ANSI_RESET + ANSI_YELLOW + areAnagram + ANSI_RESET);
            System.out.println("--------------------------------");
        }
    }

    private static boolean areStringsAnagram(final String firstValue, final String secondValue) {
        final String reversed = reverse(secondValue);
        return reversed.equalsIgnoreCase(firstValue);
    }

    private static String reverse(final String secondValue) {
        if (isNull(secondValue) || secondValue.isEmpty()) {
            return "";
        }
        final int length = secondValue.length();
        return secondValue.charAt(length - 1) + reverse(secondValue.substring(0, length - 1));
    }

}
