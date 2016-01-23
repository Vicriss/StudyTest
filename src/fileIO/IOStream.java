package fileIO;

import java.io.*;

/**
 * Created by vicriss on 16-1-23.
 */
public class IOStream {
    public void fileOutPut(String fileName) throws IOException {
        FileOutputStream out = new FileOutputStream(fileName,true);
        out.write('A');
        out.close();
    }

    public void fileCopy(String oriFile, String desFile) throws IOException {
        FileInputStream in = new FileInputStream(oriFile);
        FileOutputStream out = new FileOutputStream(desFile);
        byte[] buff = new byte[in.available()];
        in.read(buff);
        out.write(buff);
        out.close();
        in.close();
    }
}
