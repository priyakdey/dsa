package com.priyakdey.algorithms.nt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
    })
    void test_gcd(long x, long y, long expected) {
        long actual = NumberTheoryUtils.gcd(x, y);
        assertEquals(expected, actual,
            () -> String.format("expected %d, but got %d", expected, actual));
    }


}