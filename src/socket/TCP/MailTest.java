package socket.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Base64;

/**
 * Created by wybe on 6/11/16.
 */
public class MailTest {

    private BufferedReader br;
    private PrintWriter pw;

    public void clientSocket() throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        String userEmail = "3322547451@qq.com";
//        String userEmail = "vicriss@163.com";
        String userEmail = "vicriss@sina.com";
        System.out.println("your mail: " + new String(Base64.getEncoder().encode(userEmail.getBytes())));
//        String password = "hjzzdiiskpkpdcbb";
//        String password = "uestc328";
        String password = "vic2sina";
        System.out.println("password: " + new String(Base64.getEncoder().encode(password.getBytes())));
        System.out.println("Subject: ");
        String subject = input.readLine();
        System.out.println("Content: ");
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = input.readLine();
            if ("$$".equals(line)){
                break;
            }
            else {
                sb.append("\r\n");
                sb.append(line);
            }

        }

        String reciever = "vicriss@163.com";
        String data = String.format("From:<%s>\r\nTo:<%s>\r\nSubject:%s\r\n%s\r\n.\r\n",
                userEmail, reciever, subject, sb.toString());
        System.out.println(data);


        Socket socket1 = new Socket("smtp.sina.com", 25);

        pw = new PrintWriter(socket1.getOutputStream());
        br = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
        System.out.println(br.readLine());
        pw.println("HELO " + userEmail);
        pw.flush();
        System.out.println(br.readLine());
        pw.println("AUTH LOGIN");
        pw.flush();
        System.out.println(br.readLine());
        pw.println(Base64.getEncoder().encodeToString(userEmail.getBytes()));
        pw.flush();
        System.out.println(br.readLine());
        pw.println(Base64.getEncoder().encodeToString(password.getBytes()));
        pw.flush();
        System.out.println(br.readLine());

        pw.println("MAIL FROM:<" + userEmail + ">");
        pw.flush();
        System.out.println(br.readLine());
        pw.println("RCPT TO:<" + reciever + ">");
        pw.flush();
        System.out.println(br.readLine());
        pw.println("DATA");
        pw.flush();
        System.out.println(br.readLine());
        pw.print(data);
        pw.flush();
        System.out.println(br.readLine());

        pw.println("QUIT");
        pw.flush();
        System.out.println(br.readLine());

        socket1.shutdownInput();
        socket1.shutdownOutput();
        input.close();
        br.close();
        pw.close();
        socket1.close();
    }

    public static void main(String[] args) {
        MailTest client = new MailTest();
        try {
            client.clientSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
