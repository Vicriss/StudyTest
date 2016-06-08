package XMLfile;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by vicriss on 16-1-28.
 */
public class XMLGeneration {
    @Test
    public void createXML() throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();
        // 创建节点
        Element pub = document.createElement("pub");
        Element hero = document.createElement("hero");
        Element skill = document.createElement("skill");
        // 设置节点属性
        hero.setAttribute("name", "meepo");
        skill.setTextContent("Narrator");
        // 将子节点添加到父节点
        pub.appendChild(hero);
        hero.appendChild(skill);
        // 将根节点添加到dom树
        document.appendChild(pub);

        // 获取Transformer对象
        TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer();
        // 设置XML文件换行
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        // 生成XML文件
        tf.transform(new DOMSource(document), new StreamResult(new File("src/XMLfile/pub.xml")));

    }
}
