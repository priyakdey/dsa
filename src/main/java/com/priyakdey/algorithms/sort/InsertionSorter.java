package com.priyakdey.algorithms.sort;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class InsertionSorter<T> extends Sorter<T> {

    public InsertionSorter() {
        super(null);
    }

    public InsertionSorter(Comparator<? super T> comparator) {
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

        for (int i = 1; i < length; i++) {
            int insertionIndex = findInsertionIndex(array, i);
            T element = array[i];
            if (insertionIndex != -1) {
                shiftElements(array, insertionIndex, i - 1);
                array[insertionIndex] = element;
            }
        }

    }

    private void shiftElements(T[] array, int from, int to) {
        System.arraycopy(array, from, array, from + 1, to - from + 1);
    }

    private int findInsertionIndex(T[] array, int index) {
        T element = array[index];

        int left = 0, right = index;
        int insertionIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (comparator.compare(array[mid], element) >= 0) {
                insertionIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return insertionIndex;
    }

}
