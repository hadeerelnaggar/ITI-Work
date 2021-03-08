package xpath;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

public class Lab7 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder parser = factory.newDocumentBuilder();
            factory.setIgnoringElementContentWhitespace(true);
            Document document = parser.parse(new File("C:\\Users\\Hadeer\\Desktop\\iti\\java xml api\\Day1\\src\\main\\resources\\students.xml"));
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            XPathExpression xPathExpression = xPath.compile("//Student[@sex='female']");
            NodeList nodes = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++) {
                recursiveTraverse(nodes.item(i));
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

    }

    public static void recursiveTraverse(Node root) {
        System.out.println(root.getNodeName() + " " + root.getNodeValue());
        NamedNodeMap attributes = root.getAttributes();
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                if (i == 0)
                    System.out.print("Attributes:");
                System.out.println(attributes.item(i).getNodeName() + "=" + attributes.item(i).getNodeValue());
            }
        }
        NodeList childrenList = root.getChildNodes();
        for (int i = 0; i < childrenList.getLength(); i++) {
            recursiveTraverse(childrenList.item(i));
        }
    }
}
