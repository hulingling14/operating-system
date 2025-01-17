import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
public class Demo37 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();
        int result = futureTask.get();
        System.out.println(result);
    }
}
//    static class Result {
//        public int sum = 0;
//        public Object lock = new Object();
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        Result result = new Result();
//        Thread t = new Thread() {
//            @Override
//            public void run() {
//                int sum = 0;
//                for (int i = 1; i <= 1000; i++) {
//                    sum += i;
//                }
//                synchronized (result.lock) {
//                    result.sum = sum;
//                    result.lock.notify();
//                }
//            }
//        };
//        t.start();
//        synchronized (result.lock) {
//            while (result.sum == 0) {
//                result.lock.wait();
//            }
//            System.out.println(result.sum);
//        }
//    }

//    private static int result;
//
//    public static void main(String[] args) throws InterruptedException {
//        Thread t = new Thread(() -> {
//            int sum = 0;
//            for (int i = 0; i < 1000; i++) {
//                sum += i;
//            }
//            result = sum;
//        });
//        t.start();
//        t.join();
//
//        System.out.println("result =" + result);
//    }
