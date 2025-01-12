import java.util.Scanner;

public class Demo21 {

    private static volatile int n = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (n == 0) {
                // 啥都不写
            }
            System.out.println("t1 线程结束循环");
        });

        Thread t2 = new Thread(() -> {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入一个整数:");
            n = sc.nextInt();
        });

        t1.start();
        t2.start();
    }
}
