package factorial;

import java.util.Scanner;

import static util.ConsoleColor.*;
import static util.ConsoleColor.ANSI_RESET;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println(ANSI_YELLOW + "Enter number please: " + ANSI_RESET);
            final int number = new Scanner(System.in).nextInt();
            //final int factorial = calculateFactorialWithRecursion(number);
            final int factorial = calculateFactorialWithIteration(number);
            System.out.println("--------------------------------");
            System.out.println(ANSI_CYAN + "Factorial - " + ANSI_RESET + ANSI_YELLOW + factorial + ANSI_RESET);
            System.out.println("--------------------------------");
        }
    }

    private static int calculateFactorialWithRecursion(final int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * calculateFactorialWithRecursion(number - 1);
    }

    private static int calculateFactorialWithIteration(final int number) {
        int factorial = 1;
        for (int i = number; i > 0; i--) {
            factorial = factorial * i;
        }
        return factorial;
    }

}
