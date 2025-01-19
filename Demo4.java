import java.io.File;
import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        // deleteOnExit 在进程退出的时候删除
        File file = new File("./test.txt");
        file.deleteOnExit();
        System.out.println("执行删除完毕.");

        //起到阻塞的作用
        Scanner sc = new Scanner(System.in);
        sc.next();
    }
}
