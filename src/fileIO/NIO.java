package fileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wybe on 7/3/16.
 */
public class NIO {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        String filePath = "src/fileIO/fileoutput.txt";
        FileChannel fc = new FileInputStream(filePath).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
        fc.close();

        buffer.clear();
        buffer.asCharBuffer().put("any text");
        fc = new FileOutputStream(filePath,true).getChannel();
        fc.write(buffer);
        fc.close();
        fc = new FileInputStream(filePath).getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
        fc.close();
    }
}
