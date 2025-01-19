import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Demo11 {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("./test.txt")) {
            while (true) {
                byte[] buffer = new byte[1024];
                // n 返回值表示 read 操作，实际读取到多少个字节，因为可能填不满1024个字节
                int n = inputStream.read(buffer);
                if (n == -1) break;
                for (int i = 0; i < n; i++) {
                    System.out.printf("0x%x\n", buffer[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
