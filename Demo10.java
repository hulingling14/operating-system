import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Demo10 {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("./text.txt")) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
