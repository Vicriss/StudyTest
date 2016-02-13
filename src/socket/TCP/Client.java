package socket.TCP;

import org.testng.annotations.Test;
import phoneBook.Person;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Created by vicriss on 16-2-2.
 */
public class Client {
    private BufferedReader br;
    private PrintWriter pw;
    @Test
    public void clientSocket() throws IOException {
        Socket socket = new Socket("localhost", 8888);

        pw = new PrintWriter(socket.getOutputStream());
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            Logger.getAnonymousLogger().info("input: ");
            String str = input.readLine();
            if (!"bye".equals(str))
                pw.println(str);
            else
                break;
            pw.flush();

            String line = br.readLine();
            Logger.getAnonymousLogger().info(line);

        }

        socket.shutdownInput();
        socket.shutdownOutput();
        input.close();
        br.close();
        pw.close();
        socket.close();
    }

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.clientSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
