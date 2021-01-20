package fibonacciseries;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int ONE = 1;
    private static final int TWO = 2;
    final static List<Integer> results = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Enter number to print: ");
        final int fibonacciCount = new Scanner(System.in).nextInt();
        getFibonacciNumberUsingListIteration(fibonacciCount);
        getFibonacciNumberUsingRecursion(fibonacciCount);
    }

    // ----------------------------------------------------------------------------------

    private static void getFibonacciNumberUsingRecursion(final int fibonacciCount) {
        for (int number = ONE; number <= fibonacciCount; number++) {
            results.add(getFibonacciWithRecursion(number));
        }
        System.out.println(results);
        results.clear();
    }

    private static int getFibonacciWithRecursion(final int number) {
        if (number == ONE || number == TWO) {
            return ONE;
        }
        return getFibonacciWithRecursion(number - ONE) + getFibonacciWithRecursion(number - TWO);
    }

    // ----------------------------------------------------------------------------------

    private static void getFibonacciNumberUsingListIteration(final int fibonacciCount) {
        int currentValue = ONE;
        while (results.size() != fibonacciCount) {
            currentValue = getNextFibonacciNumber(currentValue);
        }
        System.out.println(results);
        results.clear();
    }

    private static int getNextFibonacciNumber(final int currentValue) {
        if (currentValue == ONE && results.isEmpty()) {
            results.add(currentValue);
            return currentValue;
        } else if (currentValue == ONE && results.size() == ONE) {
            results.add(currentValue);
            return currentValue;
        }
        final int newFibonacciValue = currentValue + results.get(results.size() - 2);
        results.add(newFibonacciValue);
        return newFibonacciValue;
    }

}
