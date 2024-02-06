package com.priyakdey.algorithms.nt;

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

    public static long lcm(long x, long y) {
        // TODO: Handle negative numbers
        return (x * y) / gcd(x, y);
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
