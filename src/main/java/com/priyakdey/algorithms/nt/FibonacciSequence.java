package com.priyakdey.algorithms.nt;

/**
 * Helper class with different method to work with fibonacci sequence.
 *
 * @author Priyak Dey
 */
public final class FibonacciSequence {

    private FibonacciSequence() {
    }

    /**
     * Returns the nth term of the fibonacci sequence.
     * This method will cause overflow issues if n is moderately large.
     *
     * @param n term of the sequence
     * @return nth term of the fibonacci sequence
     */
    public static long findNthTerm(int n) {
        if (n < 0) throw new IllegalArgumentException("n cannot be negative");
        if (n <= 1) return n;

        long previous = 0, current = 1;

        for (long i = 2; i <= n; i++) {
            long temp = previous;
            previous = current;
            current = temp + current;
        }

        return current;
    }

    /**
     * Returns the nth fibonacci sequence after mod.
     *
     * @param n   nth term of sequence
     * @param mod number with which sequence needs to mod
     * @return last digit of the nth fibonacci term when mod with input mod
     */
    public static long findNthTerm(long n, int mod) {
        if (n < 0) throw new IllegalArgumentException("n cannot be negative");
        if (n <= 1) return n;

        int pisanoPeriod = findPisanoPeriod(mod);
        n = n % pisanoPeriod;

        long previous = 0, current = 1;

        for (long i = 2; i <= n; i++) {
            long temp = previous;
            previous = current;
            current = (temp + current) % mod;
        }

        return current;
    }

    /**
     * Returns the last digit of the sum of the first n terms of sequence.
     *
     * @param n nth term
     * @return last digit of sum of the first n terms of sequence
     */
    public static long findNthTermSumLastDigit(long n) {
        if (n < 0) throw new IllegalArgumentException("n cannot be negative");
        if (n <= 1) return n;

        int pisanoPeriod = findPisanoPeriod(10);
        n = n % pisanoPeriod;

        long nPlus2TermLastDigit = findNthTerm(n + 2, 10);

        long lastDigitOfSum = nPlus2TermLastDigit - 1;
        if (lastDigitOfSum < 0) lastDigitOfSum += 10;

        return lastDigitOfSum;
    }

    /**
     * Find the sum of fibonacci sequence from m to n terms, both included.
     *
     * @param m start range, inclusive
     * @param n end range, inclusive
     * @return sum of fibonacci terms between m and n term, inclusive
     */
    public static long findPartialSumLastDigit(long m, long n) {
        if (m < 0 || n < 0) throw new IllegalArgumentException("n cannot be negative");

        int pisanoPeriod = findPisanoPeriod(10);
        n = n % pisanoPeriod;

        long mPlus1LastDigit = findNthTerm(m + 1, 10);
        long nPlus2LastDigit = findNthTerm(n + 2, 10);

        long sumLastDigit = (nPlus2LastDigit - 1) - (mPlus1LastDigit - 1);
        if (sumLastDigit < 0) sumLastDigit += 10;
        return sumLastDigit;
    }


    /**
     * Find the last digit of the sum of square of n terms of fibonacci sequence.
     *
     * @param n term of the sequence
     * @return last digit of the sum of square of n terms of fibonacci sequence.
     */
    public static long findSumOfSquaresLastDigit(long n) {
        if (n < 0) throw new IllegalArgumentException("n cannot be negative");
        if (n <= 1) return n;

        int pisanoPeriod = findPisanoPeriod(10);
        n = n % pisanoPeriod;

        long nLastDigit = findNthTerm(n, 10);
        long nPlus1LastDigit = findNthTerm(n + 1, 10);

        return (nLastDigit * nPlus1LastDigit) % 10;
    }


    /**
     * Finds the <a href="https://en.wikipedia.org/wiki/Pisano_period">Pisano Period</a> for mod.
     * It is a period, after which the sequence becomes cyclic when mod with a number.
     *
     * @param mod number with which sequence needs to be mod
     * @return pisano period for mod
     */
    private static int findPisanoPeriod(int mod) {
        int previous = 0, current = 1;
        int pisanoPeriod = -1;

        for (int i = 0; i < mod * mod; i++) {
            int temp = previous;
            previous = current;
            current = (temp + current) % mod;
            if (previous == 0 && current == 1) {
                pisanoPeriod = i + 1;
                break;
            }
        }

        return pisanoPeriod;
    }

}
