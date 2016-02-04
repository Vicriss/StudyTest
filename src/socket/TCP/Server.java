package socket.TCP;

import org.testng.annotations.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by vicriss on 16-2-2.
 */
public class Server {
    @Test
    public void serverSocket() throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        // 通过socket获取输入流
        InputStream is = socket.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
//        BufferedReader br = new BufferedReader(isr);
//        String line = null;
//        while ((line = br.readLine()) != null) {
//            System.out.println(line);
//            br.readLine();
//        }

        // 对象反序列化
        ObjectInputStream ois = new ObjectInputStream(is);
        Object obj = ois.readObject();
        System.out.println(obj);

        // 关闭输入流
        socket.shutdownInput();

        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("welcome");
        pw.flush();
        socket.shutdownOutput();

        // 关闭资源
        pw.close();
        os.close();
//        br.close();
//        isr.close();
        ois.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
