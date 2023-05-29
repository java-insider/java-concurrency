package concurrency.core;

import java.util.stream.DoubleStream;

public class GregorySeriesCalculator {

    public static final int NUM_ITERATIONS = 10_000_000;
    public static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();

    public double calculate() throws InterruptedException {

        double[] partials = new double[NUM_THREADS];

        GregorySeriesPartialCalculator[] threads = new GregorySeriesPartialCalculator[NUM_THREADS];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new GregorySeriesPartialCalculator(i, partials);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        return DoubleStream.of(partials).sum() * 4;
    }
}
