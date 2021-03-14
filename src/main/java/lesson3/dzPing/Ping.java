package lesson3.dzPing;

class Ping implements Runnable {
    PingPong q;

    public Ping(PingPong q) {
        this.q = q;
        new Thread(this, "ping").start();
    }

    @Override
    public void run() {
        while (q.n<100) {
            q.ping();
        }
    }
}