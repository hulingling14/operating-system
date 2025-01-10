class MyRunnable implements Runnable{
    @Override
    public void run() {
        // 描述了线程要完成的逻辑是啥
        while(true){
            System.out.println("hello Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

//通过 Runnable 的方式来创建线程
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable=new MyRunnable();
        Thread t=new Thread(runnable);
        t.start();

        while(true){
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
