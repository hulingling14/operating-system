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

        // 获取一下线程的这些属性
        System.out.println("线程id：" + t.getId());
        System.out.println("线程名字：" + t.getName());
        System.out.println("线程状态：" + t.getState());
        System.out.println("线程优先级：" + t.getPriority());
    }
}
