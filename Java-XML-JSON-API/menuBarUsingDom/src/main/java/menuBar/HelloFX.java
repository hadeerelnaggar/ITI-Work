package menuBar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class HelloFX extends Application {
    Document document;
    Menu menu;
    MenuBar menubar;
    MenuItem menuItem;

    @Override
    public void start(Stage stage) {
        document = createDom();
        if (document == null) {
            return;
        }
        menubar = new MenuBar();
        traverseDocument(document.getDocumentElement());
        Scene scene = new Scene(new AnchorPane(menubar), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    private void traverseDocument(Node element) {
        if (element.getNodeType() == Node.ELEMENT_NODE) {
            if (element.getNodeName().equals("Menu")) {
                NamedNodeMap attr = element.getAttributes();
                if (attr != null) {
                    String value = attr.getNamedItem("value").getNodeValue();
                    menu = new Menu(value);
                    menubar.getMenus().add(menu);
                }

            }
            else if (element.getNodeName().equals("MenuItem")) {
                menuItem = new MenuItem();
                menu.getItems().add(menuItem);
            }
        }
        else if (element.getNodeType() == Node.TEXT_NODE) {
            if (element.getNodeValue().charAt(0) != '\n') {
                menuItem.setText(element.getNodeValue());
            }
        }
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            traverseDocument(children.item(i));
        }

    }

    private Document createDom() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder parser = factory.newDocumentBuilder();
            factory.setIgnoringElementContentWhitespace(true);
            Document document = parser.parse(new File("C:\\Users\\Hadeer\\Desktop\\iti\\java xml api\\menuBarUsingDom\\src\\main\\resources\\menu.xml"));
            return document;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        launch();
    }

}