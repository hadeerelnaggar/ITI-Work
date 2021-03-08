package trax;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Lab5 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("Notes");
            Element note = document.createElement("Note");
            Attr typeAttribute = document.createAttribute("type");
            typeAttribute.setNodeValue("reminder");
            Element from = document.createElement("From");
            from.setTextContent("Hadeer");
            Element to = document.createElement("To");
            to.setTextContent("Farah");
            Element body = document.createElement("body");
            body.setTextContent("xml is awesome");

            root.appendChild(note);
            note.appendChild(from);
            note.appendChild(to);
            note.appendChild(body);
            note.setAttribute("type", "reminder");
            document.appendChild(root);
            DOMSource domSource = new DOMSource(document);
            FileOutputStream fileOutputStream = new FileOutputStream(new File("note.xml"));
            StreamResult streamResult = new StreamResult(fileOutputStream);
            TransformerFactory factory1 = TransformerFactory.newInstance();
            Transformer transformer = factory1.newTransformer();
            transformer.transform(domSource, streamResult);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
