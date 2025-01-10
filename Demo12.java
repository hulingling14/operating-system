public class Demo12 {
    private static boolean isQuit = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (!isQuit) {
                System.out.println("hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t 线程执行结束");
        });

        t.start();

        Thread.sleep(2000);
        //修改 isQuit 变量，就能够影响到 t 线程结束了
        System.out.println("main 线程尝试终止 t 线程");
        isQuit = true;
    }
}
