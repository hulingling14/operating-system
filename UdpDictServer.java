import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpDictServer extends UdpEchoServer {
    private Map<String, String> dict = new HashMap<>();

    public UdpDictServer(int port) throws SocketException {
        super(port);

        dict.put("cat", "小猫");
        dict.put("dog", "小狗");
        dict.put("pig", "小猪");
        dict.put("sheep", "小羊");
        // 真实的词典服务器需要很多很多的单词，可能是上万个
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request, "未知单词");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server = new UdpDictServer(9090);
        server.start();
    }
}
