import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo12 {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("./test.txt", true)) {
            byte[] buffer = new byte[]{(byte) 0xe4, (byte) 0xbd, (byte) 0xa0, (byte) 0xe5, (byte) 0xe5, (byte) 0xbd};
            outputStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
