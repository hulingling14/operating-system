import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo40 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        //构造方法的数字，就是拆分出来的任务个数
        CountDownLatch countDownLatch = new CountDownLatch(20);

        for (int i = 0; i < 20; i++) {
            int id = i;
            executorService.submit(() -> {
                System.out.println("下载任务 " + id + "");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("下载任务 " + id + " 结束执行");
                //完毕 over
                countDownLatch.countDown();
            });
        }

        // 当 countDownLatch 收到了 20 个 “完成”，所有的任务就都完成了
        // await => all wait
        // await 这个词也是计算机术语，在python / js 意思是 async wait（异步等待）
        countDownLatch.await();

        System.out.println("所有任务都完成");
    }
}
