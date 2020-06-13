package coursec.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket(InetAddress.getByName("127.0.0.1"),8010);
        OutputStream out = client.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        System.out.println("开始发送消息");
        dos.writeChars("Hello!I am client+" +
                "-644444444444444" +
                "" +
                "+++" +
                "+");
        client.close();
        dos.close();
        out.close();
    }
}
