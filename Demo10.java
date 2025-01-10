public class Demo10 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("t");
            Thread t2 = new Thread(() -> {
                System.out.println("t2");
            });
            t2.start();
        });
        t.start();
    }
}
