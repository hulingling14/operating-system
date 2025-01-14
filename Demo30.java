import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo30 {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1000);

        // 生产者线程
        Thread t1 = new Thread(() -> {
            int i = 1;
            while (true) {
                try {
                    queue.put(i);
                    System.out.println("生产元素 " + i);
                    i++;

                    // 给生产操作，加上 sleep，生产慢点，消费快点
                    //Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //消费者线程
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    Integer i = queue.take();
                    System.out.println("消费元素 " + i);

                    // 给消费操作，加上 sleep，生产快点，消费慢点
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
