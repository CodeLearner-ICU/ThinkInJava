package coursec.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(3000);
        byte[] data = new byte[100];
        DatagramPacket dp = new DatagramPacket(data,100);
        System.out.println("Client is waiting for receiving...");
        ds.receive(dp);
        System.out.println("Client was received and message is : "+String.valueOf(dp.getData()));
    }
}
