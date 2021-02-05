package bubblesort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final int[] array = new int[]{7, 3, 6, 4, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(final int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int previous = array[j];
                int next = array[j + 1];
                if (next < previous) {
                    array[j] = next;
                    array[j + 1] = previous;
                }
            }
        }
    }

}
