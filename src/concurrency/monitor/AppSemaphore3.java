package concurrency.monitor;

import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class AppSemaphore3 {

    public static void main(String[] args) throws Exception {

        Semaphore semaphore = new Semaphore(3);

        IntStream
            .range(0, 10)
            .mapToObj(i -> new Car(i + 1, semaphore))
            .forEach(Thread::start);
    }

    private static class Car extends Thread {

        private final int id;
        private final Semaphore semaphore;

        public Car(int id, Semaphore semaphore) {
            this.id = id;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                System.out.format("[%d] Chegou à fronteira\n", id);

                semaphore.acquire();

                System.out.format("[%d] Checagem iniciada\n", id);

                Thread.sleep((int) (Math.random() * 8000));

                System.out.format("[%d] Checagem terminada\n", id);

                semaphore.release();

                System.out.format("[%d] Boa viagem!\n", id);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
