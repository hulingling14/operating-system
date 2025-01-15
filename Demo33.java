import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class MyThreadPool {
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);

    //此处 n 表示创建几个线程
    public MyThreadPool(int n) {
        // 先创建出 n 个线程
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(() -> {
                // 循环的从队列中取任务
                while (true) {
                    try {
                        Runnable runnable = queue.take();
                        runnable.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }

    //添加任务
    public void submit(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }
}

public class Demo33 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            int id = i;
            pool.submit(() -> {
                System.out.println("执行任务" + id + "," + Thread.currentThread().getName());
            });
        }
    }
}
