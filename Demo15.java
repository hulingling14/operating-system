public class Demo15 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("hello t1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1 结束");
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("hello t2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 结束");
        });

        t1.start();
        t2.start();
        System.out.println("主线程等待开始");
        t1.join();
        t2.join();
        System.out.println("主线程等待结束");
    }
}
