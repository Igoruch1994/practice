package stringbubblesort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final String[] values = new String[]{"d", "c", "a", "f", "q"};
        sort(values);
        System.out.println(Arrays.toString(values));
    }

    private static void sort(final String[] values) {
        boolean swapped = true;
        int length = values.length - 2;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < length; i++) {
                if (values[i].compareTo(values[i + 1]) > 0) {
                    swap(values, i, i + 1);
                    swapped = true;
                }
            }
            length--;
        }
    }

    private static void swap(final String[] values, final int from, final int to) {
        final String fromValue = values[from];
        values[from] = values[to];
        values[to] = fromValue;
    }

}
