package concurrency.other;

public class AppThreadPriority {

    public static void main(String[] args) {

        Thread t = new Thread(() -> System.out.println("Hello!"));

        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t.getPriority());
    }
}
