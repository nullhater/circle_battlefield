package org.nullhater.circlebattlefield.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.infra.Blackhole;

public class NanoTimeVsCurrentTimeMillis {

    @Benchmark
    @Fork(value = 1, warmups = 1)
    public void nanoTime(Blackhole blackhole) {
        blackhole.consume(System.nanoTime());
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    public void currentTimeMillis(Blackhole blackhole) {
        blackhole.consume(System.currentTimeMillis());
    }
}
