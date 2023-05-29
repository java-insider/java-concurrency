package concurrency.monitor;

import java.util.stream.Stream;

public class AppSynchronizedCounter1 {

    private static final Object MONITOR = new Object();
    private static int counter = 0;

    public static void main(String[] args) {

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {

                synchronized (MONITOR) {
                    counter++;
                }

                sleep(10);
            }
        };

        var threads = Stream
            .generate(() -> new Thread(runnable))
            .limit(3)
            .toList();

        threads.forEach(Thread::start);
        threads.forEach(AppSynchronizedCounter1::join);

        System.out.println(counter);
    }

    private static void join(Thread t) {
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
