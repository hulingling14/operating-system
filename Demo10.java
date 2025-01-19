import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Demo10 {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("./test.txt")) {
            while (true) {
                int b = inputStream.read();
                if (b == -1) {
                    // 读取完毕了
                    break;
                }
                // 表示字节，更习惯使用十六进制打印显示
                System.out.printf("0x%x\n", b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
