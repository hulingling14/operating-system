import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String severIp, int serverPort) throws IOException {
        //这里写入ip和端口之后，意味着，new好对象之后，和服务器的连接就建立完成了
        //或者如果连接建立失败，就会直接在构造对象的时候抛出异常
        socket = new Socket(severIp, serverPort);
    }

    public void start() {
        System.out.println("客户端启动");
        try (InputStream inputStream = socket.getInputStream();//TCP是全双工的通信，一个socket对象，既可以读，也可以写
             OutputStream outputStream = socket.getOutputStream()) {
            Scanner sc = new Scanner(inputStream);
            Scanner scIn = new Scanner(System.in);
            PrintWriter printWriter = new PrintWriter(outputStream);
            while (true) {
                // 1.从控制台读取数据
                System.out.print("->");
                String request = scIn.next();
                // 2.把请求发送给服务器
                printWriter.println(request);
                printWriter.flush();
                // 3.从服务器读取响应
                if (!sc.hasNext()) {
                    break;
                }
                String response = sc.next();
                // 4.打印响应结果
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
