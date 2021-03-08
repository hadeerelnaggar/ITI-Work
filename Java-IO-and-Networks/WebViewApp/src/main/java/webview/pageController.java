package webview;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.w3c.dom.*;

import java.net.URL;
import java.util.ResourceBundle;

public class pageController implements Initializable {
    @FXML
    WebView webView;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WebEngine webEngine = webView.getEngine();
        UrlConnection urlConnection = new UrlConnection();
        webEngine.loadContent(urlConnection.getWebsiteContent("https://kordamp.org/ikonli/cheat-sheet-fontawesome5.html"));
//        Document doc = webEngine.getDocument();
//        System.out.println(doc);
//        Element head = doc.getElementById("head");
//        NodeList links = head.getElementsByTagName("link");
//        for(int i=0;i<links.getLength();i++){
//            NamedNodeMap attributes = links.item(i).getAttributes();
//            if(attributes.getNamedItem("rel").equals("stylesheet")){
//                webEngine.setUserStyleSheetLocation(attributes.getNamedItem("href").getNodeValue());
//            }
//        }


        System.out.println(webEngine.getUserStyleSheetLocation());

    }
}
