public class Demo26 {
    private static Object locker1 = new Object();

    private static Object locker2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("A");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (locker1) {
                locker1.notify();
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    locker1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("B");

            synchronized (locker2) {
                locker2.notify();
            }
        });
        Thread t3 = new Thread(() -> {
            synchronized (locker2) {
                try {
                    locker2.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C");
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
