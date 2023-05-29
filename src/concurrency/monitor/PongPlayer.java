package concurrency.monitor;

public class PongPlayer implements Runnable {

    private final PingPongGame game;

    public PongPlayer(PingPongGame game) {
        this.game = game;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                game.playPong();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
