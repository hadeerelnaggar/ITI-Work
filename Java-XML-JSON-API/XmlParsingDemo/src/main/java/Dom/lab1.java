package Dom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * Hello world!
 */
public class lab1 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder parser = factory.newDocumentBuilder();
            factory.setIgnoringElementContentWhitespace(true);
            Document document = parser.parse(new File("C:\\Users\\Hadeer\\Desktop\\iti\\java xml api\\Day1\\src\\main\\resources\\note.xml"));
            Node root = document.getDocumentElement();
            recursiveTraverse(root);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void recursiveTraverse(Node root) {
//        System.out.println(root.getNodeName() + " " + root.getNodeValue());
//        NamedNodeMap attributes = root.getAttributes();
//        if (attributes != null) {
//            for (int i = 0; i < attributes.getLength(); i++) {
//                if (i == 0)
//                    System.out.print("Attributes:");
//                System.out.println(attributes.item(i).getNodeName() + "=" + attributes.item(i).getNodeValue());
//            }
//        }
//        NodeList childrenList = root.getChildNodes();
//        for (int i = 0; i < childrenList.getLength(); i++) {
//            recursiveTraverse(childrenList.item(i));
//        }
    }
}
