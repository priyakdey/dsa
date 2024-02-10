package com.priyakdey.algorithms.nt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.priyakdey.nt.FibonacciSequence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("FibonacciTest")
class FibonacciSequenceTest {

    @ParameterizedTest(name = "test_findNthTerm")
    @CsvSource({
        "2,  1",
        "5,  5",
        "8,  21",
        "12, 144",
        "20, 6765",
        "30, 832040",
        "50, 12586269025",
    })
    void test_findNthTerm(int n, long expected) {
        long actual = FibonacciSequence.findNthTerm(n);
        assertEquals(expected, actual,
            () -> String.format("expected %o, but got %o", expected, actual));
    }

    @ParameterizedTest(name = "test_findNthTerm")
    @CsvSource({
        "1,          239,  1",
        "115,        1000, 885",
        "2816213588, 239,  151"
    })
    void test_findNthTerm(long n, int mod, long expected) {
        long actual = FibonacciSequence.findNthTerm(n, mod);
        assertEquals(expected, actual,
            () -> String.format("expected %o, but got %o", expected, actual));
    }

    @ParameterizedTest(name = "test_findNthTermSumLastDigit")
    @CsvSource({
        "3,   4",
        "100, 5",
    })
    void test_findNthTermSumLastDigit(long n, long expected) {
        long actual = FibonacciSequence.findNthTermSumLastDigit(n);
        assertEquals(expected, actual,
            () -> String.format("expected %o, but got %o", expected, actual));
    }


    @ParameterizedTest(name = "test_findPartialSumLastDigit")
    @CsvSource({
        "3,   7, 1",
        "10, 10, 5",
    })
    void test_findPartialSumLastDigit(long m, long n, long expected) {
        long actual = FibonacciSequence.findPartialSumLastDigit(m, n);
        assertEquals(expected, actual,
            () -> String.format("expected %o, but got %o", expected, actual));
    }


    @ParameterizedTest(name = "test_findSumOfSquaresLastDigit")
    @CsvSource({
        "7,          3",
        "73,         1",
        "1234567890, 0",
    })
    void test_findSumOfSquaresLastDigit(long n, long expected) {
        long actual = FibonacciSequence.findSumOfSquaresLastDigit(n);
        assertEquals(expected, actual,
            () -> String.format("expected %o, but got %o", expected, actual));
    }


}