package socket.UDP;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * Created by vicriss on 16-2-4.
 */
public class UDPClient {
    @Test
    public void client() throws IOException {
        // 发送数据
        InetAddress address = InetAddress.getByName("localhost");
        byte[] data = "hello".getBytes();
        DatagramSocket clientSocekt = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, address, 8888);
        clientSocekt.send(packet);


        // 接收响应
        byte[] data2 = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(data2,data2.length);
        clientSocekt.receive(packet2);
        String info = new String(data2);
        System.out.println("Server:" + info);
    }
}
