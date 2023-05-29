package concurrency.other;

public class AppVolatile {

    private static volatile int number;
    private static volatile boolean ready;

    private static class Executor extends Thread {

        @Override
        public void run() {
            while (!ready) { }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new Executor().start();
        number = 10;
        ready = true;
    }
}
