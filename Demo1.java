class MyThread extends Thread{
    @Override
    public void run() {
        //����д�Ĵ��룬���Ǽ������������߳�Ҫִ�е��߼�
        while(true){
            System.out.println("hello thread");
            //ѭ���У��������߲�������ѭ��ÿѭ��һ�ζ���Ϣһ�ᣬ����CPU���Ĺ���
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
        //�����߳�
        t.start();

        //run ���ᴴ���̣߳�Ҳ�������߳���ִ���߼�
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

