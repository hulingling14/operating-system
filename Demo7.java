import java.io.File;

public class Demo7 {
    public static void main(String[] args) {
        File f = new File("./abc/def/ghi");
        boolean ok = f.mkdirs();
        System.out.println(ok);
    }
}
