import java.util.Scanner;

public class Demo24 {
    private static Object locker = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("t1 wait 之前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t1 wait 之后");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker) {
                System.out.println("t2 notify 之前");
                Scanner sc = new Scanner(System.in);
                sc.next();//此处用户输入啥都行，主要是通过这个 next ，构造“阻塞”

                synchronized (locker){
                    locker.notify();
                }

                System.out.println("t2 notify 之后");
            }
        });

        t1.start();
        t2.start();
    }
}
