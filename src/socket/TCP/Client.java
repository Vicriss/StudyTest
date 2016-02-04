package socket.TCP;

import org.testng.annotations.Test;
import phoneBook.Person;

import java.io.*;
import java.net.Socket;

/**
 * Created by vicriss on 16-2-2.
 */
public class Client {
    @Test
    public void clientSocket() throws IOException {
        Socket socket = new Socket("localhost", 8888);
        OutputStream os = socket.getOutputStream();
//        PrintWriter pw = new PrintWriter(os);
//        pw.write("11111");
//        pw.flush();

        // 对象序列化
        Person person = new Person();
        person.setName("bob");
        person.setAddress("local");
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(person);
        oos.flush();

        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            br.readLine();
        }

        socket.shutdownInput();

        br.close();
        isr.close();
        is.close();
//        pw.close();
        oos.close();
        os.close();
        socket.close();
    }
}
