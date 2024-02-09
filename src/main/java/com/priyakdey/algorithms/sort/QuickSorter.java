package com.priyakdey.algorithms.sort;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class QuickSorter<T> extends Sorter<T> {

    public QuickSorter() {
        super(null);
    }

    public QuickSorter(Comparator<? super T> comparator) {
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

        int partitionIndex = lomutosPartition(array, left ,right);
//        int partitionIndex = hoaresParition(array, left ,right);

        sort(array, left, partitionIndex - 1);
        sort(array, partitionIndex + 1, right);
    }

    private int hoaresParition(T[] array, int left, int right) {
        int pivotIndex = left;
        T pivotElement = array[pivotIndex];

        while (left < right) {
            int compareStart = comparator.compare(array[left], pivotElement);
            int compareEnd   = comparator.compare(array[right], pivotElement);

            if (compareStart <= 0 && compareEnd <= 0) {
                left++;
            } else if (compareStart <= 0 && compareEnd > 0) {
                left++;
                right--;
            } else if (compareStart > 0 && compareEnd <= 0) {
                swap(array, left, right);
                left++;
                right--;
            } else if (compareStart > 0 && compareEnd > 0) {
                right--;
            }
        }

        int partitionIndex = comparator.compare(array[left], pivotElement) > 0 ? left - 1 : left;
        swap(array, partitionIndex, pivotIndex);
        return partitionIndex;
    }

    private int lomutosPartition(T[] array, int left, int right) {
        int pivotIndex = right;
        T pivotElement = array[right];

        int curr = left;
        int swapAt = left;
        while (curr < right) {
            if (comparator.compare(array[curr], pivotElement) <= 0) {
                swap(array, swapAt, curr);
                swapAt++;
            }
            curr++;
        }

        swap(array, swapAt, pivotIndex);
        return swapAt;
    }
}
