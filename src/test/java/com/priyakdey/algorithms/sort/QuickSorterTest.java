package com.priyakdey.algorithms.sort;

import static org.junit.jupiter.api.Assertions.*;

import com.priyakdey.algorithms.util.IntegerArrayConverter;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("QuickSorter")
class QuickSorterTest {

    private final Sorter<Integer> naturalOrderSorter = new QuickSorter<>();

    @ParameterizedTest(name = "test_sortInteger_naturalOrder - sort({0} -> {1}")
    @CsvSource({
        "'[1]'                             , '[1]'",
        "'[2, 1]'                          , '[1, 2]'",
        "'[3, 2, 1]'                       , '[1, 2, 3]'",
        "'[4, 3, 2, 1]'                    , '[1, 2, 3, 4]'",
        "'[-1, -3, -2]'                    , '[-3, -2, -1]'",
        "'[0, 0, 0, 0]'                    , '[0, 0, 0, 0]'",
        "'[1, 2, 3, 4, 5]'                 , '[1, 2, 3, 4, 5]'",
        "'[5, 4, 3, 2, 1]'                 , '[1, 2, 3, 4, 5]'",
        "'[1, -1, 0, 1, -1]'               , '[-1, -1, 0, 1, 1]'",
        "'[5, -4, 3, -2, 1]'               , '[-4, -2, 1, 3, 5]'",
        "'[2, 3, 3, 1, 0, -1, -1]'         , '[-1, -1, 0, 1, 2, 3, 3]'",
        "'[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]' , '[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]'",
    })
    void test_sortInteger_naturalOrder(
        @ConvertWith(IntegerArrayConverter.class) Integer[] input,
        @ConvertWith(IntegerArrayConverter.class) Integer[] expected) {

        naturalOrderSorter.sort(input);
        assertArrayEquals(expected, input,
            () -> String.format("expected %s, but got %s", Arrays.toString(expected),
                Arrays.toString(input)));
    }


}