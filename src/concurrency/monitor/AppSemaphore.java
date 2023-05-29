package concurrency.monitor;

import java.util.concurrent.Semaphore;
import java.util.stream.Stream;

public class AppSemaphore {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);

        var threads = Stream
            .generate(() -> new Thread(new CounterThread(semaphore)))
            .limit(10)
            .toList();

        threads.forEach(Thread::start);

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Count: " + CounterThread.count);
    }

    private static class CounterThread implements Runnable {

        public static int count;

        private final Semaphore semaphore;

        public CounterThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                    semaphore.acquire();
                    count++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
