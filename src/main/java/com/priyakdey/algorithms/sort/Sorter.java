package com.priyakdey.algorithms.sort;

import java.util.Comparator;

/**
 * @author Priyak Dey
 */
public abstract class Sorter<T> {

    protected final Comparator<? super T> comparator;

    protected Sorter(Comparator<? super T> comparator) {
        this.comparator =
            comparator == null ? (Comparator<? super T>) Comparator.naturalOrder() : comparator;
    }

    /**
     * Sorts the given array in place. The elements should be {@link Comparable<T>}, or
     * the sorter should be given a {@link java.util.Comparator<T>} for sorting.
     *
     * @param array input array.
     */
    public abstract void sort(T[] array);


    protected void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
