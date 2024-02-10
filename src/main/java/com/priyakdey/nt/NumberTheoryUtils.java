package com.priyakdey.nt;

import com.priyakdey.exception.TodoException;

/**
 * @author Priyak Dey
 */
public final class NumberTheoryUtils {

    private NumberTheoryUtils() {
    }

    /**
     * Returns the greatest common divisor of x and y.
     *
     * @param x int
     * @param y int
     * @return gcd of x and y
     */
    public static long gcd(long x, long y) {
        return binaryGcd(Math.abs(x), Math.abs(y));
    }

    /**
     * Returns the least common multiple of x and y
     *
     * @param x long
     * @param y long
     * @return lcm of x and y
     */
    public static long lcm(long x, long y) {
        // TODO: Handle negative cases
        // TODO: Need to handle overflows for large numbers
        return (x * y) / gcd(x, y);
    }

    /**
     * Util method to check if a number is prime.
     *
     * @param n int
     * @return true if n is prime, else false.
     */
    public static boolean isPrime(long n) {
        if (n < 2) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    /**
     * Generates primes numbers from 0 to end, inclusive.
     *
     * @param end int
     * @return array of primes in the range [0, end]
     */
    public static int[] generatePrimesTill(int end) {
        if (end < 0) throw new IllegalArgumentException("invalid argument");
        if (end <= 1) return new int[0];
        return generatePrimes(0, end);
    }

    /**
     * Generates primes numbers from start to end, both inclusive.
     *
     * @param start int start of the prime range, inclusive
     * @param end   int end of the prime range, inclusive
     * @return array of primes in the range [1, end]
     */
    public static int[] generatePrimesTill(int start, int end) {
        if (start < 0 || start > end) throw new IllegalArgumentException("invalid input");
        if (end <= 1) return new int[0];
        return generatePrimes(start, end);
    }

    /**
     * Generates the first N prime numbers.
     *
     * @param n int
     * @return array of first n prime numbers
     */
    public static int[] generateNPrimes(int n) {
        throw new TodoException("Implement efficient generatePrimes to make this work efficiently");
    }

    /* -----------------   PRIVATE METHODS ----------------- */

    private static int[] generatePrimes(int start, int end) {
        // TODO: With max size cap on array, how to work with larger numbers?
        // TODO: This is inefficient, if start is large.
        int sieveLength = end + 1;
        boolean[] sieve = new boolean[sieveLength];

        // false is prime, is this to avoid pre-filling step the array with true.
        // reverse sieve (if wormhole can exist!!!)
        sieve[0] = true;
        sieve[1] = true;

        for (int i = 2; i < sieveLength; i++) {
            if (!sieve[i]) {
                for (int j = 2; i * j < sieveLength; j++) {
                    if (!sieve[(i * j)]) {
                        sieve[i * j] = true;
                    }
                }
            }
        }

        int primeCount = 0;
        for (int i = start; i < sieveLength; i++) {
            if (!sieve[i]) primeCount++;
        }

        int[] primes = new int[primeCount];
        int cursor = 0;

        for (int i = start; i < sieveLength; i++) {
            if (!sieve[i]) primes[cursor++] = i;
        }

        return primes;
    }

    private static long iterativeGcd(long x, long y) {
        long gcd = 1;
        long min = Math.min(x, y);
        for (long i = 2; i <= min; i++) {
            if (x % i == 0 && y % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }

    private static long euclideanGcd(long x, long y) {
        if (x < y) {
            long temp = x;
            x = y;
            y = temp;
        }

        return y != 0 ? euclideanGcd(y, x % y) : x;
    }


    private static long binaryGcd(long x, long y) {
        if (x < y) {
            long temp = x;
            x = y;
            y = temp;
        }

        if (y == 0) return x;

        long shift = 0;
        while (((x | y) & 1) == 0) {
            x = x >>> 1;
            y = y >>> 1;
            shift++;
        }

        while ((x & 1) == 0) {
            x = x >>> 1;
        }

        while (y != 0) {
            while ((y & 1) == 0) {
                y = y >>> 1;
            }
            if (x < y) {
                long temp = x;
                x = y;
                y = temp;
            }
            x = x - y;
        }

        return x << shift;
    }


}
