package socket.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Created by vicriss on 16-2-13.
 */
public class ServerThread extends Thread {
    private BufferedReader br;
    private PrintWriter out;
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void init() {
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logic() throws IOException {
        String line = null;
        boolean flag = true;
        while (flag) {
            line = br.readLine();
            if (line == null || "".equals(line))
                flag = false;
            else {
                if ("bye".equals(line))
                    flag = false;
                else {
                    Logger.getAnonymousLogger().info("client: " + line);
                    response();
                }
            }
        }
    }

    public void response() {
        out.println("got it!");
        out.flush();
    }

    public void close() throws IOException {
        if(br != null)
            br.close();
        if(out != null)
            out.close();
        if(socket != null)
            out.close();
    }

    @Override
    public void run() {
        try {
            init();
            logic();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
