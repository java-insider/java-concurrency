package concurrency.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppExecutors3 {

    public static void main(String[] args) {

        ExecutorService e = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            e.submit(() -> {
                System.out.println("Executing!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }

        e.shutdown();
    }
}
