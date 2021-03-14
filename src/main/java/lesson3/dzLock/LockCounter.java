package lesson3.dzLock;


import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        ReentrantLock locker = new ReentrantLock();
        for (int i = 0; i < 300; i++) {
            CounterThread ct = new CounterThread(counter, locker);
            ct.start();
        }
        Thread.sleep(1000);
        System.out.println("LockCounter = " + counter.getCounter());
    }
}

class Counter {
    private long counter = 0L;

    public void increaseCounter() {
        counter++;
    }

    public long getCounter() {
        return counter;
    }
}

class CounterThread extends Thread {
    private Counter counter;
    ReentrantLock locker;


    public CounterThread(Counter counter, ReentrantLock locker) {
        this.counter = counter;
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock();
        try {
            for (int i = 0; i < 100; i++) {
                counter.increaseCounter();
            }
        } finally {
            locker.unlock();
        }
    }
}
