//此处不考虑泛型参数，只是基于 String 进行存储
class MyBlockingQueue {
    private String[] data = null;

    private int head = 0;

    private int tail = 0;

    private int size = 0;

    private Object locker = new Object();

    public MyBlockingQueue(int capacity) {
        data = new String[capacity];
    }

    public void put(String s) throws InterruptedException {
        synchronized (locker) {
            while (size == data.length) {
                //队列满了
                //return;
                locker.wait();
            }
            data[tail] = s;
            tail++;
            if (tail >= data.length) {
                tail = 0;
            }
            size++;

            locker.notify();
        }
    }

    public String take() throws InterruptedException {
        String ret = "";
        synchronized (locker) {
            while (size == 0) {
                //队列为空
                //return null;
                locker.wait();
            }
            ret = data[head];
            head++;
            if (head >= data.length) {
                head = 0;
            }
            size--;

            locker.notify();
        }
        return ret;
    }
}

public class Demo31 {
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue(1000);
        //BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1000);

        // 生产者线程
        Thread t1 = new Thread(() -> {
            int i = 1;
            while (true) {
                try {
                    queue.put("" + i);
                    System.out.println("生产元素 " + i);
                    i++;

                    // 给生产操作，加上 sleep，生产慢点，消费快点
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //消费者线程
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    Integer i = Integer.parseInt(queue.take());
                    System.out.println("消费元素 " + i);

                    // 给消费操作，加上 sleep，生产快点，消费慢点
                    //Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
