public class Demo23 {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        System.out.println("wait ֮ǰ");
        synchronized (obj) {
            obj.wait();
        }
        System.out.println("wait ֮��");
    }
}
