public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
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

        t.start();

        // ��ȡһ���̵߳���Щ����
        System.out.println("�߳�id��" + t.getId());
        System.out.println("�߳����֣�" + t.getName());
        System.out.println("�߳�״̬��" + t.getState());
        System.out.println("�߳����ȼ���" + t.getPriority());
    }
}
