public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        //���е� lambda �Ĵ����ڱ�������������� Thread t ���Ϸ���
        //��ʱ t ��û�б������
        Thread t = new Thread(() -> {
            //�Ȼ�ȡ���̵߳�����
            Thread currentThread = Thread.currentThread();
            while (!currentThread.isInterrupted()) {
                System.out.println("hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //throw new RuntimeException(e);
                    System.out.println("ִ�е� catch ����");
                    break;
                }
            }
        });

        t.start();

        Thread.sleep(3000);
        //�����߳��У����� t �̱߳���ֹ������������־λ
        t.interrupt();
    }
}
