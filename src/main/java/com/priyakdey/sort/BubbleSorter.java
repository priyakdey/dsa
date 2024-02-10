package com.priyakdey.sort;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class BubbleSorter<T> extends Sorter<T> {

    public BubbleSorter() {
        super(null);
    }

    public BubbleSorter(Comparator<? super T> comparator) {
        super(comparator);
    }

    /**
     * Sorts the given array in place. The elements should be {@link Comparable<T>}, or
     * the sorter should be given a {@link Comparator <T>} for sorting.
     *
     * @param array input array.
     */
    @Override
    public void sort(T[] array) {
        Objects.requireNonNull(array);

        int length = array.length;
        if (length <= 1) return;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }

    }
}
