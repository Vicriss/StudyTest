package socket.TCP;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * Created by vicriss on 16-2-2.
 */
public class Server {
    private ServerSocket serverSocket;
    private Socket client;

    @Test
    public void listen() throws IOException, ClassNotFoundException {
        serverSocket = new ServerSocket(8888);
        Logger.getAnonymousLogger().info("server started...");
        ExecutorService es = Executors.newCachedThreadPool();
        Boolean keepRunning = true;
        while (keepRunning) {
            client = serverSocket.accept();
            if(client.isConnected()) {
                Logger.getAnonymousLogger().info("client connected...");
                es.execute(new ServerThread(client));
            }
        }
        Logger.getAnonymousLogger().info("server stop!");
        es.shutdown();
        serverSocket.close();
    }
}
