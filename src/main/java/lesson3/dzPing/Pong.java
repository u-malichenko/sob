package lesson3.dzPing;

class Pong implements Runnable {
    PingPong q;

    public Pong(PingPong q) {
        this.q = q;
        new Thread(this, "pong").start();
    }

    @Override
    public void run() {
        while (q.n<100) {
            q.pong();
        }
    }
}
