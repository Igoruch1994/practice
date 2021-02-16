package insertsort;

import java.util.Arrays;

public class Main {

    /**
     * Good example of how insert sort work is here:
     * https://www.youtube.com/watch?v=OGzPmgsI-pQ
     */

    public static void main(String[] args) {
        final int[] array = new int[]{6, 3, 3, 7, 5, 2, 1};
        sort(array);
        System.out.println("Sorted array : " + Arrays.toString(array));
    }

    private static void sort(final int[] array) {
        for (int i = 1; i < array.length; i++) {
            final int key = array[i];
            int previous = i - 1;
            while (previous >= 0 && key < array[previous]) {
                final int lastElement = array[previous + 1];
                array[previous + 1] = array[previous];
                array[previous] = lastElement;
                previous--;
            }
        }
    }

}
