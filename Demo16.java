public class Demo16 {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();

        Thread t = new Thread(() -> {
            // ��Ҫ�� t �е������߳�.join
            System.out.println("t �߳̿�ʼ�ȴ�");
            try {
                mainThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t �߳̽����ȴ�");
        });
        t.start();

        Thread.sleep(2000);
        System.out.println("main �߳̽���");
    }
}
