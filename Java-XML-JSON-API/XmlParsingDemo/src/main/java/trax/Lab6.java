package trax;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab6 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder parser = factory.newDocumentBuilder();
            Document document = parser.parse(new File("C:\\Users\\Hadeer\\Desktop\\iti\\java xml api\\Day1\\src\\main\\resources\\students.xml"));
            DOMSource doc = new DOMSource(document);

            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document instrDoc = builder.parse(new File("C:\\Users\\Hadeer\\Desktop\\iti\\java xml api\\Day1\\src\\main\\resources\\inst.xsl"));
            DOMSource instrSource = new DOMSource(instrDoc);

            FileOutputStream fileOutputStream = new FileOutputStream(new File("transform.html"));
            StreamResult result = new StreamResult(fileOutputStream);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(instrSource);
            transformer.transform(doc, result);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }

}
