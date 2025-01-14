import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo29 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.put("11");
        System.out.println("put 成功");
        queue.put("11");
        System.out.println("put 成功");

        queue.take();
        System.out.println("take 成功");
        queue.take();
        System.out.println("take 成功");
        queue.take();
        System.out.println("take 成功");
    }
}
