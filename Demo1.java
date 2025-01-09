class MyThread extends Thread{
    @Override
    public void run() {
        //这里写的代码，就是即将创建出的线程要执行的逻辑
        while(true){
            System.out.println("hello thread");
            //循环中，加上休眠操作，让循环每循环一次都休息一会，避免CPU消耗过大
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Demo1 {
    public static void main(String[] args) {
        MyThread t=new MyThread();
        //创建线程
        t.start();

        //run 不会创建线程，也是在主线程中执行逻辑
        //t.run();

        while(true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

