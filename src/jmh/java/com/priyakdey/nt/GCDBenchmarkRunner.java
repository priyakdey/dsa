package com.priyakdey.nt;

import java.io.IOException;
import java.util.Random;
import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

/**
 * @author Priyak Dey
 */
public class GCDBenchmarkRunner {

    private static final Random rand = new Random();

    public static void main(String[] args) throws IOException {
        Main.main(args);
    }


    @Benchmark
    public static void gcd(Blackhole blackhole) {
        long x = rand.nextLong();
        long y = rand.nextLong();
        blackhole.consume(NumberTheoryUtils.gcd(x, y));
    }


}
