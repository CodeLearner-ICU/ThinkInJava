package coursec.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String test = "Hello World.Now we can talk.";
        DatagramPacket dp = new DatagramPacket(test.getBytes(),test.length(), InetAddress.getByName("127.0.0.1"),3000);
        System.out.println("开始发送消息。");
        ds.send(dp);
        System.out.println("发送结束.");
    }
}
