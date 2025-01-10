public class Demo6 {
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
        },"�Զ����߳�");

        t.start();

        while (true) {
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
