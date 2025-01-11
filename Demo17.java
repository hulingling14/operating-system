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

        //���� t �߳��ǳ��� while ѭ������� join ���᷵��
        //�۲����̵߳�״̬�����ܿ��� waiting
        t.join();

        //System.out.println(t.getState());
    }
}
