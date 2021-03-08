package sax;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Lab3 {
    public static void main(String[] args) {
        try{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        CallBackHandler callBackHandler = new CallBackHandler();
        parser.parse(new File("C:\\Users\\Hadeer\\Desktop\\iti\\java xml api\\Day1\\src\\main\\resources\\note.xml"),callBackHandler);
        }
        catch (ParserConfigurationException e){
            e.printStackTrace();
        }
        catch (SAXException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


