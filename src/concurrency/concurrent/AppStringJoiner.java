package concurrency.concurrent;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppStringJoiner {

    public static void main(String[] args) throws InterruptedException {

        try (ExecutorService e = Executors.newSingleThreadExecutor()) {
            StringJoinerRunnable runnable = new StringJoinerRunnable(List.of("A", "B", "C"));
            //e.execute(runnable);

            Future<?> future = e.submit(runnable);
            future.get();

            System.out.println(runnable.getResult());

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
