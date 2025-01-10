public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        //下列的 lambda 的代码在编译器眼里，出现在 Thread t 的上方的
        //此时 t 还没有被定义的
        Thread t = new Thread(() -> {
            //先获取到线程的引用
            Thread currentThread = Thread.currentThread();
            while (!currentThread.isInterrupted()) {
                System.out.println("hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //throw new RuntimeException(e);
                    System.out.println("执行到 catch 操作");
                    break;
                }
            }
        });

        t.start();

        Thread.sleep(3000);
        //在主线程中，控制 t 线程被终止，设置上述标志位
        t.interrupt();
    }
}
