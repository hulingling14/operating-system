import java.util.concurrent.atomic.AtomicInteger;

public class Demo36 {
    // private static int count = 0;

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count.getAndIncrement();   // count++;
//                count.incrementAndGet();   //++count;
//                count.getAndIncrement();   //count--;
//                count.decrementAndGet();   //--count;
//                count.getAndAdd(10); //count+= 10;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                // count++;
                count.getAndIncrement();   // count++;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        //通过 count.get() 拿到原子类内部持有的真实数据
        System.out.println("count = " + count);
    }
}
