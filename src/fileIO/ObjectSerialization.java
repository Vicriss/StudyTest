package fileIO;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import phoneBook.Person;

import java.io.*;

/**
 * Created by vicriss on 16-1-23.
 */
public class ObjectSerialization {
    public void objectSer(Object obj, String fileName) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(fileName));

        oos.writeObject(obj);
        oos.flush();
        oos.close();
    }

    public Object objectDeSer(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(fileName));

        Object obj = ois.readObject();
        System.out.println(obj);
        ois.close();
        return obj;
    }
}
