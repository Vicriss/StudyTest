package fileIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vicriss on 16-1-23.
 */
public class StreamRW {
    public void streamReader(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(in);
        int c;
        char[] buff = new char[8*1024];
        isr.read(buff);
        String s = new String(buff);
        System.out.print(s);

        isr.close();
        in.close();
    }
}
