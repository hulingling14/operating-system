public class Demo16 {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();

        Thread t = new Thread(() -> {
            // 需要在 t 中调用主线程.join
            System.out.println("t 线程开始等待");
            try {
                mainThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t 线程结束等待");
        });
        t.start();

        Thread.sleep(2000);
        System.out.println("main 线程结束");
    }
}
