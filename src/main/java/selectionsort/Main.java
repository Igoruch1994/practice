package selectionsort;

import java.util.Arrays;

import static util.ConsoleColor.*;

public class Main {

    public static void main(String[] args) {
        final int[] values = new int[] {5, 2 ,1 ,7, 2, 1};
        sort(values);
        System.out.println(ANSI_GREEN + "Sorted array : " + ANSI_RESET + ANSI_YELLOW + Arrays.toString(values));
    }

    private static void sort(final int[] values) {
        for (int i = 0; i < values.length; i++) {
            final int minIndex = getMinIndex(values, i);
            int currentValue = values[i];
            values[i] = values[minIndex];
            values[minIndex] = currentValue;
        }
    }

    private static int getMinIndex(final int[] values, final int startIndex) {
        int minValueIndex = 0;
        int minValue = values[startIndex];
        for (int i = startIndex; i < values.length; i++) {
            if (values[i] <= minValue) {
                minValue = values[i];
                minValueIndex = i;
            }
        }
        return minValueIndex;
    }

}
