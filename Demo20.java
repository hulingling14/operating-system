public class Demo20 {
    private static Object locker1 = new Object();

    private static Object locker2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                System.out.println("t1 加锁 locker1 完成");

                //这里的 sleep 是为了确保，t1 和 t2 都先分别拿到 locker1 和 locker2 然后再分别拿对方的锁
                //如果没有 sleep 执行顺序就不可控，可能出现某个线程一口气拿到两把锁，另一个线程还没执行呢，无法构造出死锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (locker2) {
                    System.out.println("t1 加锁 locker2 完成");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker1) {
                System.out.println("t2 加锁 locker1 完成");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (locker2) {
                    System.out.println("t2 加锁 locker2 完成");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
