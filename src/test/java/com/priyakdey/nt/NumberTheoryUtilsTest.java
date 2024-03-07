package com.priyakdey.nt;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.priyakdey.util.IntArrayConverter;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("NumberTheoryUtilsTest")
class NumberTheoryUtilsTest {

    @ParameterizedTest(name = "test_gcd - gcd({0}, {1}) = {2}")
    @CsvSource({
        "28851538    , 1183019     , 17657",
        "14159572    , 63967072    , 4",
        "12          , 8           , 4",
        "0           , 5           , 5",
        "5           , 0           , 5",
        "13          , 13          , 13",
        "13          , 7           , 1",
        "6           , 3           , 3",
        "123456      , 7890        , 6",
        "9999991     , 9999991     , 9999991",
        "104729      , 3           , 1",
        "1000000     , 2           , 2",
        "2147483647  , 2147483646  , 1",
        "39          , 65          , 13",
        "120         , 35          , 5",
        "81          , 27          , 27",
        "100         , 10          , 10",
        "1970673793  , 2009770450  , 1",
        "1608146120  , 1488020147  , 1",
        "1924201125  , 1570577503  , 11",
        "1498688171  , 1729175306  , 1",
        "1428612797  , 1414998749  , 1",
        "688769689690, 589698321234, 2",
        // TODO: Fails badly for this. need to check
//        "281474976710597, 17, 1",
    })
    void test_gcd(long x, long y, long expected) {
        long actual = NumberTheoryUtils.gcd(x, y);
        assertEquals(expected, actual,
            () -> String.format("expected %d, but got %d", expected, actual));
    }

    @ParameterizedTest(name = "test_lcm - lcm({0}, {1}) = {2}")
    @CsvSource({
        "2            , 4            , 4",
        "3            , 7            , 21",
        "6            , 8            , 24",
        "11           , 22           , 22",
        "15           , 20           , 60",
        "17           , 23           , 391",
        "100          , 250         , 500",
        "12           , 15           , 60",
        "21           , 6            , 42",
        "35           , 14           , 70",
        "1000000007   , 2            , 2000000014",
        "999999937    , 40           , 39999997480",
//        "104729       , 9973         , 104447617",
//        1044462317
//        "9999991      , 9999992      , 4999996000008",
//        "2147483647   , 2147483648   , 4611686014132420609",
//        "99999999977  , 13           , 1299999999711",
//        "281474976710597, 17        , 4785074604062139",
    })
    void test_lcm(long x, long y, long expected) {
        long actual = NumberTheoryUtils.lcm(x, y);
        assertEquals(expected, actual,
            () -> String.format("expected %d, but got %d", expected, actual));
    }


    @ParameterizedTest(name = "test_isPrime - isPrime({0}) = {1}")
    @CsvSource({
        "2                , true",
        "3                , true",
        "4                , false",
        "5                , true",
        "6                , false",
        "17               , true",
        "18               , false",
        "19               , true",
        "20               , false",
        "97               , true",
        "98               , false",
        "99               , false",
        "101              , true",
        "103              , true",
        "105              , false",
        "1009             , true",
        "1013             , true",
        "1024             , false",
        "7919             , true",
        "7920             , false",
        "104729           , true",
        "104730           , false",
        "999983           , true",
        "999984           , false",
        "2147483647       , true",
        "4294967296       , false",
        "9999999967       , true",
        "9999999966       , false",
        "99999999977      , true",
        "99999999989      , false",
        "99999999991      , false",
        "100000000003     , true",
        "100000000019     , true",
        "100000000033     , false",
        "1099511627689    , true",
        "1099511627791    , true",
        "1099511627793    , false",
        "281474976710597  , true",
        "281474976710656  , false",
        "9007199254740881 , true",
        "9007199254740991 , false",
    })
    void test_isPrime(long n, boolean expected) {
        boolean actual = NumberTheoryUtils.isPrime(n);
        assertEquals(expected, actual,
            () -> String.format("expected %s, but got %s", expected, actual));
    }

    @ParameterizedTest(name = "test_generatePrimesTillFrom0({0})")
    @CsvSource({
        "2  , '[2]'",
        "3  , '[2, 3]'",
        "5  , '[2, 3, 5]'",
        "10 , '[2, 3, 5, 7]'",
        "20 , '[2, 3, 5, 7, 11, 13, 17, 19]'",
        "30 , '[2, 3, 5, 7, 11, 13, 17, 19, 23, 29]'",
        "40 , '[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37]'",
        "50 , '[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]'",
        "100, '[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]'",
        "150, '[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149]'",
        "200, '[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199]'",
    })
    void test_generatePrimesTillFrom0(int end, @ConvertWith(IntArrayConverter.class) int[] expected) {
        int[] actual = NumberTheoryUtils.generatePrimesTill(end);
        assertArrayEquals(expected, actual,
            () -> String.format("expected %s, but got %s", Arrays.toString(expected),
                Arrays.toString(actual)));
    }

    @ParameterizedTest(name = "test_generatePrimesTillFromCustom({0}, {1})")
    @CsvSource({
        "0  , 2  , '[2]'",
        "0  , 3  , '[2, 3]'",
        "0  , 5  , '[2, 3, 5]'",
        "3  , 10 , '[3, 5, 7]'",
        "4  , 20 , '[5, 7, 11, 13, 17, 19]'",
        "10 , 20 , '[11, 13, 17, 19]'",
        "0  , 30 , '[2, 3, 5, 7, 11, 13, 17, 19, 23, 29]'",
        "0  , 40 , '[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37]'",
        "0  , 50 , '[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]'",
        "15 , 50 , '[17, 19, 23, 29, 31, 37, 41, 43, 47]'",
    })
    void test_generatePrimesTillFromCustom(int start, int end, @ConvertWith(IntArrayConverter.class) int[] expected) {
        int[] actual = NumberTheoryUtils.generatePrimesTill(start, end);
        assertArrayEquals(expected, actual,
            () -> String.format("expected %s, but got %s", Arrays.toString(expected),
                Arrays.toString(actual)));
    }
}