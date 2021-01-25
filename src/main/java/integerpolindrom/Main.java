package integerpolindrom;

import java.util.Scanner;

import static util.ConsoleColor.*;
import static util.ConsoleColor.ANSI_RESET;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println(ANSI_YELLOW + "Enter number please: " + ANSI_RESET);
            final int number = new Scanner(System.in).nextInt();
            final boolean isWordPolindrom = isNumberPolindrom(number);
            System.out.println("--------------------------------");
            System.out.println(ANSI_CYAN + "Polindrom? - " + ANSI_RESET + (isWordPolindrom ?
                    ANSI_YELLOW + "Yes" + ANSI_RESET : ANSI_RED + "No" + ANSI_RESET));
            System.out.println("--------------------------------");
        }
    }

    private static boolean isNumberPolindrom(final int number) {
        int reverse = getReverse(number);
        return reverse == number;
    }

    private static int getReverse(final Integer number) {
        int polindrom = number;
        int reverse = 0;
        while (polindrom > 0) {
            final int remainder = polindrom % 10;
            reverse = reverse * 10 + remainder;
            polindrom = polindrom / 10;
        }
        return reverse;
    }

}
