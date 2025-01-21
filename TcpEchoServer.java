import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {
    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("启动服务器");
        ExecutorService service = Executors.newCachedThreadPool();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            // 创建线程，每个线程服务一个客户端
//            Thread t = new Thread(() -> {
//                try {
//                    processConnection(clientSocket);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//            t.start();

            // 使用线程池
            service.submit(() -> {
                try {
                    processConnection(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    //针对一个连接，提供处理逻辑
    private void processConnection(Socket clientSocket) throws IOException {
        // 先打印一下客户端的信息
        System.out.printf("[%s:%d] 客户端上线！\n", clientSocket.getInetAddress(), clientSocket.getPort());
        // 获取到 socket 中持有的流对象
        try (InputStream inputStream = clientSocket.getInputStream();//TCP是全双工的通信，一个socket对象，既可以读，也可以写
             OutputStream outputStream = clientSocket.getOutputStream()) {
            Scanner sc = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);
            while (true) {
                if (!sc.hasNext()) {
                    break;
                }
                String request = sc.next();
                String response = process(request);
                printWriter.println(response);
                printWriter.flush();
                System.out.printf("[%s:%d] req=%s;resp=%s\n", clientSocket.getInetAddress(), clientSocket.getPort(),
                        request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("[%s:%d] 客户端下线！\n", clientSocket.getInetAddress(), clientSocket.getPort());
            clientSocket.close();
            //ServerSocket,DatagramSocket他们的生命周期，都是跟随整个进程的
            //这里的clientSocket是"连接级别"的数据
            //随着客户端断开连接了，这个socket也就不再使用了
            //(即使是同一个客户端，断开之后，重新连接，也是一个新socket,和旧socket不是同一个了)
            //因此，这样的socket就应该主动关闭掉=>以防文件资源泄露
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}
