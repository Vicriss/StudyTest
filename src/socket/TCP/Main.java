package socket.TCP;

import java.io.IOException;

/**
 * Created by vicriss on 16-2-13.
 */
public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.listen();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
