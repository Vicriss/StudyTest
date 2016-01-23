package fileIO;

import java.io.*;

/**
 * Created by vicriss on 16-1-23.
 */
public class BufferedRW {
    public void bufferedWriter(String srcName, String desName) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(srcName)));

        PrintWriter pw = new PrintWriter(desName);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.print(line);
            pw.println(line);
            pw.flush();
        }
        pw.close();
        br.close();
    }
}
