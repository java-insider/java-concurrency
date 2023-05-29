package concurrency.other;

public class AppThreadName {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> System.out.println("Hello!"));
        t1.setName("T1");

        Thread t2 = new Thread(() -> System.out.println("Hello!"));
        t2.setName("T2");

        Thread.currentThread().setName("MainThread");

        System.out.println(Thread.currentThread().getName());
        System.out.println(t1.getName());
        System.out.println(t2.getName());
    }
}
