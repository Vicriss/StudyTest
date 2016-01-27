package XMLfile;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by vicriss on 16-1-27.
 */
public class Main {
    public static void main(String[] args) {
        XMLReader xmlReader = new XMLReader();
        try {
            xmlReader.reader();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
