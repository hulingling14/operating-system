import java.io.File;

public class Demo3 {
    public static void main(String[] args) {
        File file = new File("./Lisen.js");
        boolean ok = file.delete();
        System.out.println(ok);
    }
}
