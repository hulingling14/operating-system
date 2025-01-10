public class Demo8 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        //把t设为守护线程（后台线程），不再能阻止进程结束了
        t.setDaemon(true);
        t.start();

        // 主线程不写循环，主线程瞬间就执行完了
    }
}
