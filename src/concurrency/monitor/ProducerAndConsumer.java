package concurrency.monitor;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerAndConsumer {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        Producer p1 = new Producer("P1", queue, 10);
        Producer p2 = new Producer("P2", queue, 10);
        Producer p3 = new Producer("P3", queue, 10);

        Consumer c1 = new Consumer("C1", queue);
        Consumer c2 = new Consumer("C2", queue);

        p1.start();
        p2.start();
        p3.start();

        c1.start();
        c2.start();
    }
}
