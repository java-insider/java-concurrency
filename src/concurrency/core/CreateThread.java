package concurrency.core;

public class CreateThread {

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();

        new Thread(() -> System.out.println("MyThread2 here!")).start();

        System.out.println("main()");
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("MyThread here!");
        }
    }
}
