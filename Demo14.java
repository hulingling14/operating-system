//�̵߳ȴ�
public class Demo14 {
    public static void main(String[] args) throws InterruptedException {
        // ���߳����洴�� t �߳�
        Thread t = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("�����߳� t");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("�߳� t ����");
        });

        t.start();

        Thread.sleep(4000);
        //�����̵߳ȴ�t�߳�
        System.out.println("main �߳̿�ʼ�ȴ�");
        t.join();
        System.out.println("main �߳̽����ȴ�");
    }
}
