package concurrency.monitor;

import java.util.stream.Stream;

public class AppSynchronizedCounter2 {

    public static void main(String[] args) {
        var threads = Stream
            .generate(CounterThread::new)
            .limit(3)
            .toList();

        threads.forEach(Thread::start);
        threads.forEach(AppSynchronizedCounter2::join);

        System.out.println(CounterThread.getCounter());
    }

    private static class CounterThread extends Thread {

        private static final Object MONITOR = new Object();
        private static int counter = 0;

        @Override
        public void run() {
            synchronized (MONITOR) {
                for (int i = 0; i < 10; i++) {
                    counter++;
                }
                AppSynchronizedCounter2.sleep(10);
            }
        }

        public static int getCounter() {
            return counter;
        }
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
