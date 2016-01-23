package fileIO;

import phoneBook.Person;

import java.io.IOException;

/**
 * Created by vicriss on 16-1-23.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        IOStream ioStream = new IOStream();
//        ioStream.fileCopy("src/factory/properties",
//                "src/fileIO/fileoutput.txt");

//        StreamRW s = new StreamRW();
//        s.streamReader("src/fileIO/fileoutput.txt");

//        BufferedRW b = new BufferedRW();
//        b.bufferedWriter("src/factory/properties",
//                "src/fileIO/fileoutput.txt");

        ObjectSerialization os = new ObjectSerialization();
//        Person person = new Person();
//        person.setName("vicriss");
//        os.objectSer(person,"src/fileIO/fileoutput.txt");
        os.objectDeSer("src/fileIO/fileoutput.txt");

    }
}
