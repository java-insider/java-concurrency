package concurrency.other;

public class AppThreadYield {

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);

                Thread.yield();
            }
        }).start();
    }
}
