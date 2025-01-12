import java.util.Scanner;

public class Demo25 {
    private static Object locker = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("t1 wait 之前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1 wait 之后");
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("t2 wait 之前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 wait 之后");
            }
        });
        Thread t3 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("t3 wait 之前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3 wait 之后");
            }
        });
        Thread t4 = new Thread(() -> {
            Scanner sc = new Scanner(System.in);
            sc.next();
            System.out.println("t4 notify 之前");
            synchronized (locker) {
                locker.notify();
                locker.notify();
                locker.notify();
                locker.notify();
                locker.notify();
                locker.notify();
                locker.notify();
                locker.notify();
                locker.notify();
                locker.notify();
            }
            System.out.println("t4 notify 之后");
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
