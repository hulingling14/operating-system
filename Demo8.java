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


        //��t��Ϊ�ػ��̣߳���̨�̣߳�����������ֹ���̽�����
        t.setDaemon(true);
        t.start();

        // ���̲߳�дѭ�������߳�˲���ִ������
    }
}
