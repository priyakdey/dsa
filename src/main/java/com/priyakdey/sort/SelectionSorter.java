package com.priyakdey.sort;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class SelectionSorter<T>  extends Sorter<T> {

    public SelectionSorter() {
        super(null);
    }

    public SelectionSorter(Comparator<? super T> comparator) {
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
            int indexOfSmallest = i;
            for (int j = i + 1; j < length; j++) {
                if (comparator.compare(array[j], array[indexOfSmallest]) < 0) {
                    indexOfSmallest = j;
                }
            }

            if (indexOfSmallest != i) {
                swap(array, indexOfSmallest, i);
            }
        }

    }
}
