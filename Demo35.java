import java.util.PriorityQueue;

class MyTimerTask implements Comparable<MyTimerTask> {
    private Runnable runnable;
    //此处这里的 time，通过毫秒时间戳，表示这个任务具体啥时候执行
    private long time;

    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    public void run() {
        runnable.run();
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        // 此处这里的 - 的顺序，就决定了这里是大堆还是小堆
        // 此处需要小堆
        return (int) (this.time - o.time);
    }
}

class MyTimer {
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();

    private Object locker = new Object();

    public MyTimer() {
        // 创建线程，负责执行上述队列中的内容
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    synchronized (locker) {
                        while (queue.isEmpty()) {
                            locker.wait();
                        }
                        MyTimerTask current = queue.peek();
                        // 比如，当前时间是 10：30，任务时间是 12：00，不应该执行
                        // 如果当前时间是 10：30，任务时间是 10：29，应该执行
                        if (System.currentTimeMillis() >= current.getTime()) {
                            // 要执行任务
                            current.run();
                            //把执行过的任务，从队列中删除
                            queue.poll();
                        } else {
                            // 先不执行任务
                            locker.wait(current.getTime() - System.currentTimeMillis());
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }

    public void schedule(Runnable runnable, long delay) {
        synchronized (locker) {
            MyTimerTask myTimerTask = new MyTimerTask(runnable, delay);
            queue.offer(myTimerTask);
            locker.notify();
        }
    }
}

public class Demo35 {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(() -> {
            System.out.println("hello 3000");
        }, 3000);
        myTimer.schedule(() -> {
            System.out.println("hello 2000");
        }, 2000);
        myTimer.schedule(() -> {
            System.out.println("hello 1000");
        }, 1000);
        System.out.println("程序开始执行");
    }
}
