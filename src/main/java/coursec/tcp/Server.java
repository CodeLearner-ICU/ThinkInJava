package coursec.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于tcp协议的通信
 */
public class Server {
        public static void main (String[]args) throws IOException {
            ServerSocket server = new ServerSocket(8010);
            System.out.println("开始接收信息");
            Socket socket = server.accept();
            System.out.println("收到消息");
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            System.out.println("客户端发送的消息："+br.readLine());
            in.close();
            br.close();
            server.close();
        }

}
