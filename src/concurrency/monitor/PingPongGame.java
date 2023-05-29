package concurrency.monitor;

public class PingPongGame {

    private boolean isPingTurn = true;

    public synchronized void playPing() throws InterruptedException {

        while (!isPingTurn) {
            wait();
        }

        System.out.println("Ping!");
        isPingTurn = false;
        notify();
    }

    public synchronized void playPong() throws InterruptedException {

        while (isPingTurn) {
            wait();
        }

        System.out.println("Pong!");
        isPingTurn = true;
        notify();
    }

    public static void main(String[] args) throws Exception {
        PingPongGame game = new PingPongGame();

        Thread pingPlayer = new Thread(new PingPlayer(game));
        Thread pongPlayer = new Thread(new PongPlayer(game));

        pingPlayer.start();
        pongPlayer.start();

        pingPlayer.join();
        pongPlayer.join();
    }
}
