import java.util.Timer;
import java.util.TimerTask;

public class Demo34 {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello3");
            }
        }, 3000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello2");
            }
        }, 2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello1");
            }
        }, 1000);

        System.out.println("程序开始运行");
    }
}
