package XMLfile;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by vicriss on 16-1-27.
 */
public class XMLReader {

    public void reader() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse("src/XMLfile/spring-mvc.xml");
        // 根据标签名获取节点
        NodeList beans = document.getElementsByTagName("bean");
        for(int i = 0; i < beans.getLength(); i++) {
            Node bean = beans.item(i);
            // 获取节点属性
            NamedNodeMap attrs = bean.getAttributes();
            for(int j = 0; j < attrs.getLength(); j++) {
                Node attr = attrs.item(j);
                System.out.println(i+1 + "-" + (j+1) + ")" + attr.getNodeName() + ":" + attr.getNodeValue());
            }
            // 获取子节点
            NodeList childBeans = bean.getChildNodes();
            System.out.println(childBeans.getLength() + "childen");

            for (int k = 0; k < childBeans.getLength(); k++) {
                Node child = childBeans.item(k);
                if (child.getNodeType() == Node.ELEMENT_NODE){
                    System.out.println("CHILD:" + child.getTextContent());
                }
            }
            System.out.println();

        }

    }

}
