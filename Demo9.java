public class Demo9 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(t.isAlive());

        t.start();

        System.out.println(t.isAlive());
        Thread.sleep(5000);
        System.out.println(t.isAlive());
    }
}
