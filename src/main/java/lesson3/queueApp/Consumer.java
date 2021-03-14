package lesson3.queueApp;

class Consumer implements Runnable {
    SyncQueue q;

    public Consumer(SyncQueue q) {
        this.q = q;
        new Thread(this, "Потребитель").start();
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }
}
