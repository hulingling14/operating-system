import java.io.File;
import java.util.Arrays;

public class Demo5 {
    public static void main(String[] args) {
        File file = new File(".");
        System.out.println(Arrays.toString(file.list()));
        file = new File("./out");
        System.out.println(Arrays.toString(file.list()));
    }
}
