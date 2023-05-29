package concurrency.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerAndConsumer {

    public static void main(String[] args) {
        ItemsQueue queue = new ItemsQueue(10);
        int numProducers = 3;
        int numConsumers = 2;

        ExecutorService e = Executors.newFixedThreadPool(numProducers + numConsumers);

        for (int i = 1; i <= numProducers; i++) {
            e.submit(new Producer("P" + i, queue));
        }

        for (int i = 1; i <= numConsumers; i++) {
            e.submit(new Consumer("C" + i, queue));
        }
    }
}
