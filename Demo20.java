public class Demo20 {
    private static Object locker1 = new Object();

    private static Object locker2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                System.out.println("t1 ���� locker1 ���");

                //����� sleep ��Ϊ��ȷ����t1 �� t2 ���ȷֱ��õ� locker1 �� locker2 Ȼ���ٷֱ��öԷ�����
                //���û�� sleep ִ��˳��Ͳ��ɿأ����ܳ���ĳ���߳�һ�����õ�����������һ���̻߳�ûִ���أ��޷����������
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (locker2) {
                    System.out.println("t1 ���� locker2 ���");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker1) {
                System.out.println("t2 ���� locker1 ���");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (locker2) {
                    System.out.println("t2 ���� locker2 ���");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
