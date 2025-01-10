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
            System.out.println("t �߳�ִ�н���");
        });

        t.start();

        Thread.sleep(2000);
        //�޸� isQuit ���������ܹ�Ӱ�쵽 t �߳̽�����
        System.out.println("main �̳߳�����ֹ t �߳�");
        isQuit = true;
    }
}
