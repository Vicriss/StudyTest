package designPattern.factory;

import java.io.*;
import java.util.Properties;

/**
 * Created by vicriss on 2015/09/09.
 */
public class FactoryTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IOException {
       Factory factory = new Factory();
        Properties properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream("src/designPattern/factory/properties")));
        String className = properties.getProperty("truck");
        CarInterface train = factory.getCarByClassName(className);
        System.out.println(train.creator());
    }
}
