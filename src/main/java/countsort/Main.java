package countsort;

import java.util.Arrays;

import static util.ConsoleColor.*;

public class Main {

    public static void main(String[] args) {
        final int[] values = new int[]{3, 5, 6, 7, 5, 4};
        sort(values);
    }

    private static void sort(final int[] values) {
        final int max = findMax(values);
        final int[] medianArray = new int[max + 1];
        countNumberOfDistinctValuesInList(values, medianArray);
        calculatePositions(medianArray);
        final int[] sortedArray = sortArray(values, max, medianArray);
        System.out.println(ANSI_GREEN + "Sorted array : " + ANSI_RESET + ANSI_YELLOW + Arrays.toString(sortedArray));
    }

    private static int[] sortArray(final int[] values,
                                   final int max,
                                   final int[] medianArray) {
        final int[] sorted = new int[max];
        for (int value : values) {
            populateValueInSortedArray(sorted, value, medianArray[value]);
        }
        return sorted;
    }

    private static void populateValueInSortedArray(final int[] sorted,
                                                   final int value,
                                                   final int index) {
        final int valueInSortedArray = sorted[index];
        if (valueInSortedArray > 0) {
            populateValueInSortedArray(sorted, value, index - 1);
        } else {
            sorted[index] = value;
        }
    }

    private static void calculatePositions(final int[] medianArray) {
        for (int i = 1; i < medianArray.length; i++) {
            medianArray[i] = medianArray[i - 1] + medianArray[i];
        }
    }

    private static void countNumberOfDistinctValuesInList(final int[] values,
                                                          final int[] medianArray) {
        for (int value : values) {
            medianArray[value]++;
        }
    }

    private static int findMax(final int[] values) {
        return Arrays.stream(values).max().getAsInt();
    }

}
