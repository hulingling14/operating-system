class MyRunnable implements Runnable{
    @Override
    public void run() {
        // �������߳�Ҫ��ɵ��߼���ɶ
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

//ͨ�� Runnable �ķ�ʽ�������߳�
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
