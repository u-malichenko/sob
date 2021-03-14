package lesson3.dzPing;

public class PingPongApp {
    public static void main(String[] args) {
        PingPong q = new PingPong();
        new Ping(q);
        new Pong(q);
    }
}
