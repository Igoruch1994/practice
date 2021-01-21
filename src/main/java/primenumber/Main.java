package primenumber;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter number to print: ");
        final int lastNumber = new Scanner(System.in).nextInt();
        for (int i = 1; i < lastNumber; i++) {
            boolean numberIsPrime = isNumberPrime(i);
            if (numberIsPrime) {
                System.out.print(i + ",");
            }
        }
    }

    private static boolean isNumberPrime(final int value) {
        if (value == 2) {
            return true;
        }
        if (value % 2 == 0 || (value % 3 == 0 && value != 3) || (value % 5 == 0 && value != 5) || (value % 7 == 0 && value != 7)) {
            return false;
        }
        final double sqrt = Math.sqrt(value);
        final double floor = Math.floor(sqrt);
        if (sqrt - floor == 0) {
            return false;
        }
        final int sqrtInt = (int) sqrt + 1;
        for (int i = 2; i < sqrtInt; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

}
