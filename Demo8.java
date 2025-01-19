import java.io.File;

public class Demo8 {
    public static void main(String[] args) {
        File srcFile = new File("./ABC/def");
        File destFile = new File("./def");
        boolean ok = srcFile.renameTo(destFile);
        System.out.println(ok);
    }
}
