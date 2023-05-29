package concurrency.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ExAppender {

    public static void main(String[] args) {

        Appender appender = new Appender();
        CountDownLatch countDownLatch = new CountDownLatch(10);

        try (ExecutorService e = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 10; i++) {
                char c = (char) (i + 65);
                e.submit(() -> {
                    appender.append(c);
                    countDownLatch.countDown();
                });
            }

            countDownLatch.await();
            System.out.println("String = " + appender);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Appender {

        private final StringBuilder sb = new StringBuilder();
        private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public void append(char c) {
            lock.writeLock().lock();
            try {
                sb.append(c);
            } finally {
                lock.writeLock().unlock();
            }
        }

        @Override
        public String toString() {
            lock.readLock().lock();
            try {
                return sb.toString();
            } finally {
                lock.readLock().unlock();
            }
        }
    }
}
