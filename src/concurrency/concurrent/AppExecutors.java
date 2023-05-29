package concurrency.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppExecutors {

    public static void main(String[] args) {

        ExecutorService e = Executors.newSingleThreadExecutor();

        e.submit(() -> {
            System.out.println("Executing!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        e.submit(() -> {
            System.out.println("Executing!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        e.shutdown();
    }
}
