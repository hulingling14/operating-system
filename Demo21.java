import java.util.Scanner;

public class Demo21 {

    private static volatile int n = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (n == 0) {
                // ɶ����д
            }
            System.out.println("t1 �߳̽���ѭ��");
        });

        Thread t2 = new Thread(() -> {
            Scanner sc = new Scanner(System.in);
            System.out.println("������һ������:");
            n = sc.nextInt();
        });

        t1.start();
        t2.start();
    }
}
