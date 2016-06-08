package socket.UDP;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by vicriss on 16-2-4.
 */
public class UDPServer {
    @Test
    public void server() throws IOException {
        /**
         * 接收请求
         */
        // 1.创建服务端socket,指定端口
        DatagramSocket serverSocket = new DatagramSocket(8888);
        // 2.创建数据报,用于接受客户端发送的数据
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        // 3.接收数据
        serverSocket.receive(packet);
        // 4.读取数据
        String info = new String(data,0,packet.getLength());
        System.out.println("Client:" + info);


        /**
         * 做出响应
         */
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        System.out.println(serverSocket.getPort() + "," + packet.getPort());
        byte[] reponse = "welcome".getBytes();
        DatagramPacket packet2 = new DatagramPacket(reponse, 0, reponse.length, address, port);
        serverSocket.send(packet2);
        // 5.关闭资源
        serverSocket.close();
    }
}
