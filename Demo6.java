import java.io.File;

public class Demo6 {
    private static void scan(File currentDir) {
        // 1.先判断是否是目录
        if (!currentDir.isDirectory()) {
            return;
        }

        // 2.列出当前目录中包含的内容
        File[] files = currentDir.listFiles();

        // 3.打印当前目录
        System.out.println(currentDir.getAbsolutePath());
        // 4.遍历这里所有的内容，依次进行判定
        for (File f : files) {
            if (f.isFile()) {
                // 如果是普通文件，直接打印文件路径
                System.out.println(f.getAbsolutePath());
            } else {
                scan(f);
            }
        }
    }

    public static void main(String[] args) {
        File f = new File("./");

        scan(f);
    }
}
