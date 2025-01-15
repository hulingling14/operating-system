import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo32 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 100; i++) {
            int id = i;
            service.submit(() -> {
                Thread current = Thread.currentThread();
                System.out.println("hello Thread" + id + "," + current.getName());
            });
        }

        // 最好不要立即终止，可能使任务还没执行完呢，线程就终止了
        Thread.sleep(2000);

        // 把线程池里所有的线程都终止掉
        service.shutdown();
        System.out.println("程序退出");
    }
}
