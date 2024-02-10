package com.priyakdey.sort;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class MergeSorter<T> extends Sorter<T> {

    public MergeSorter() {
        super(null);
    }

    public MergeSorter(Comparator<? super T> comparator) {
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

        sort(array, 0, length - 1);
    }

    private void sort(T[] array, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, mid + 1, right);
    }

    @SuppressWarnings("unchecked")
    private void merge(T[] array, int leftFrom, int leftTo, int rightFrom, int rightTo) {
        int length = rightTo - leftFrom + 1;
        T[] mergedArray = (T[]) Array.newInstance(array.getClass().componentType(), length);

        int i = leftFrom, j = rightFrom;
        int cursor  = 0;

        while (i <= leftTo && j <= rightTo) {
            if (comparator.compare(array[i], array[j]) <= 0) {
                mergedArray[cursor++] = array[i++];
            } else {
                mergedArray[cursor++] = array[j++];
            }
        }

        while (i <= leftTo) {
            mergedArray[cursor++] = array[i++];
        }

        while (j <= rightTo) {
            mergedArray[cursor++] = array[j++];
        }

        System.arraycopy(mergedArray, 0, array, leftFrom, length);
    }


}
