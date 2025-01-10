//线程等待
public class Demo14 {
    public static void main(String[] args) throws InterruptedException {
        // 主线程里面创建 t 线程
        Thread t = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("这是线程 t");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程 t 结束");
        });

        t.start();

        Thread.sleep(4000);
        //让主线程等待t线程
        System.out.println("main 线程开始等待");
        t.join();
        System.out.println("main 线程结束等待");
    }
}
