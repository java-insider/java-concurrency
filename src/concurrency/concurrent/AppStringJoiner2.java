package concurrency.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppStringJoiner2 {

    public static void main(String[] args) throws Exception {

        try (ExecutorService e = Executors.newSingleThreadExecutor()) {
            Future<String> future = e.submit(new StringJoinerCallable(null));

            try {
                System.out.println(future.get());
            } catch (ExecutionException ex) {
                Throwable cause = ex.getCause();
                System.out.println("ERROR: " + cause.getMessage());
                cause.printStackTrace();
            }
        }
    }
}
