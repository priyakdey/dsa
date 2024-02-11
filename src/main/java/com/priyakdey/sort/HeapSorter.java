package com.priyakdey.sort;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class HeapSorter<T> extends Sorter<T> {

    public HeapSorter() {
        super(null);
    }

    public HeapSorter(Comparator<? super T> comparator) {
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

        // heapify the array from last non-leaf node - index = (n - 2) / k to root.
        for (int i = (length - 2) / 2; i >= 0; i--) {
            heapify(array, i, length);
        }

        // move root to last index of the unsorted slice and then heapify the remaining
        for (int i = length - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, 0, i);
        }
    }

    private void heapify(T[] array, int rootIndex, int length) {
        int swapIndex = rootIndex;

        int leftIndex  = 2 * rootIndex + 1;
        int rightIndex = 2 * rootIndex + 2;

        if (leftIndex < length && comparator.compare(array[leftIndex], array[swapIndex]) > 0) {
            swapIndex = leftIndex;
        }

        if (rightIndex < length && comparator.compare(array[rightIndex], array[swapIndex]) > 0) {
            swapIndex = rightIndex;
        }

        if (swapIndex != rootIndex) {
            swap(array, rootIndex, swapIndex);
            heapify(array, swapIndex, length);
        }
    }

}
