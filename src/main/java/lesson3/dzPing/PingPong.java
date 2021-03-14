package lesson3.dzPing;

public class PingPong {
    int n;
    boolean flag = false;

    synchronized void pong() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Pong " + n);
        flag = false;
        notify();
    }

    synchronized void ping() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        n++;
        System.out.println("Ping " + n);
        flag = true;
        notify();
    }
}
