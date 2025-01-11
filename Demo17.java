public class Demo17 {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();

        Thread t = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("main state=" + mainThread.getState());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(t.getState());

        t.start();

        //由于 t 线程是持续 while 循环，因此 join 不会返回
        //观察主线程的状态，就能看到 waiting
        t.join();

        //System.out.println(t.getState());
    }
}
