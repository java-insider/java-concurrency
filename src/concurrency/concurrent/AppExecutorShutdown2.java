package concurrency.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AppExecutorShutdown2 {

    public static void main(String[] args) {
        try (ExecutorService e = Executors.newSingleThreadExecutor()) {
            e.submit(() -> {
                System.out.println("Task...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Task ended");
            });
        }
    }
}
