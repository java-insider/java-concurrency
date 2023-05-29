package concurrency.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppExecutors4 {

    public static void main(String[] args) {

        ScheduledExecutorService e = Executors.newScheduledThreadPool(1);

        //e.schedule(() -> System.out.println("Good morning!"), 3, TimeUnit.SECONDS);
        e.scheduleWithFixedDelay(() -> System.out.println("Good morning!"), 3, 1, TimeUnit.SECONDS);

        //e.shutdown();
    }
}
