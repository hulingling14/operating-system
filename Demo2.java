import java.io.File;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("./Lisen.js");

        boolean ok = file.createNewFile();
        System.out.println(ok);

        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }
}
