package bucketsort;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class Main {

    public static void main(String[] args) {
        float[] values = {(float) 0.897, (float) 0.656, (float) 0.565, (float) 0.1234, (float) 0.665, (float) 0.3434};
        sortWithBuckets(values);
    }

    private static void sortWithBuckets(final float[] values) {
        final float max = findMaxOrMinValue(values, Main::getMax);
        final float min = findMaxOrMinValue(values, Main::getMin);
        final float range = calculateRange(values, max, min);
        final List<Float>[] buckets = populateBuckets(values, min, range);
        sortValuesInBuckets(buckets);
        final List<Float> sortedValues = concatenateBuckets(buckets);
        System.out.println(sortedValues);
    }

    private static float calculateRange(final float[] values,
                                        final float max,
                                        final float min) {
        return (max - min) / (values.length - 1);
    }

    private static List<Float> concatenateBuckets(final List<Float>[] buckets) {
        return Arrays.stream(buckets).filter(Objects::nonNull).flatMap(Collection::stream).collect(Collectors.toList());
    }

    private static void sortValuesInBuckets(final List<Float>[] buckets) {
        Arrays.stream(buckets).filter(b -> nonNull(b) && !b.isEmpty() && b.size() > 1).forEach(Main::insertSort);
    }

    private static void insertSort(final List<Float> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            float key = bucket.get(i);
            int previous = i - 1;
            while (previous >= 0 && key < bucket.get(previous)) {
                final Float previousValue = bucket.get(previous);
                bucket.set(previous, key);
                bucket.set(previous + 1, previousValue);
                previous--;
            }
        }
    }

    private static List<Float>[] populateBuckets(final float[] values,
                                                 final float min,
                                                 final float range) {
        final List<Float>[] buckets = new List[values.length];
        for (float value : values) {
            final int bucketPosition = Math.round((value - min) / range);
            if (buckets[bucketPosition] == null) {
                List<Float> list = new ArrayList<>();
                list.add(value);
                buckets[bucketPosition] = list;
            } else {
                buckets[bucketPosition].add(value);
            }
        }
        return buckets;
    }


    private static float findMaxOrMinValue(final float[] values, final BiFunction<Float, Float, Float> function) {
        float max = values[0];
        for (int i = 1; i < values.length; i++) {
            max = function.apply(values[i], max);
        }
        return max;
    }

    private static float getMax(float value, float max) {
        if (max < value) {
            max = value;
        }
        return max;
    }

    private static float getMin(float value, float min) {
        if (min > value) {
            min = value;
        }
        return min;
    }

}
