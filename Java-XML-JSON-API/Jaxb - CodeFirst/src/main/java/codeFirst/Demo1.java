package codeFirst;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Demo1
{
    public static void main( String[] args )
    {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

            List<Address> addresses = new ArrayList<>();
            Address address = new Address(3228,"solimania");
            addresses.add(address);
            address = new Address(123,"zayed");
            addresses.add(address);
            Student student = new Student("hadeer",123,"Java",addresses);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(student,new FileWriter("students.xml"));

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Student student2 = (Student) unmarshaller.unmarshal(new FileReader("students.xml"));
            System.out.println(student2);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
