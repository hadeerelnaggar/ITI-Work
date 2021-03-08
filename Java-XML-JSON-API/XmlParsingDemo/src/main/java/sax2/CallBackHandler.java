package sax2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class CallBackHandler extends DefaultHandler {
    ArrayList<Student> students;
    Student student;
    String validTag = "";
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("Document starting...");
        students=new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        System.out.println(qName);
        if(qName.equals("Student")){
            student=new Student();
            student.setSex(attributes.getValue("sex"));
        }
        validTag=qName;

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        System.out.println("/"+qName);
        if(qName.equals("Student"))
            students.add(student);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String text = String.valueOf(ch);
        String value = text.substring(start,start+length);
        if(value.charAt(0)=='\n'){
            return;
        }
        if(validTag.equals("Name"))
            student.setName(value);
        else if(validTag.equals("Id"))
            student.setId(value);
        else if(validTag.equals("Track"))
            student.setTrack(value);
        System.out.println();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        for(int i=0;i<students.size();i++){
            System.out.println(students.get(i));
        }
    }
}
