package lesson3.queueApp;

class Producer implements Runnable {
    SyncQueue q;

    public Producer(SyncQueue q) {
        this.q = q;
        new Thread(this, "Отправитель").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}