package lesson3.deadlock;

public class Deadlock {
    Object obj1 = new Object();
    Object obj2 = new Object();

    public static void main(String[] args) {
        Deadlock dead = new Deadlock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                dead.deadlock();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                dead.deadlock1();
            }
        }).start();
    }

    public void deadlock() {
        synchronized (obj1) {
            System.out.println("Поток 1 получает монитор на obj1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Поток 1 пытается получить монитор на obj2");
            synchronized (obj2) {
                System.out.println("Поток 1 получает монитор на obj2");
            }
        }
    }

    public void deadlock1() {
        synchronized (obj2) {
            System.out.println("Поток 2 получает монитор на obj2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Поток 2 пытается получить монитор на obj1");
            synchronized (obj1) {
                System.out.println("Поток 2 получает монитор на obj2");
            }
        }
    }
}
