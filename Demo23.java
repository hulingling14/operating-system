public class Demo23 {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        System.out.println("wait 之前");
        synchronized (obj) {
            obj.wait();
        }
        System.out.println("wait 之后");
    }
}
