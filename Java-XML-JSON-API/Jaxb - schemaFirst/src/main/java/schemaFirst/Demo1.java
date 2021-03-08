package schemaFirst;

import jakarta.xml.bind.*;
import schemaFirst.models.Address;
import schemaFirst.models.Person;

import java.io.File;
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
            JAXBContext jaxbContext = JAXBContext.newInstance("schemaFirst.models");

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<Person> jaxbElement = (JAXBElement<Person>) unmarshaller.unmarshal(new File("person.xml"));
            Person person = jaxbElement.getValue();
            System.out.println(person.getFirstName());
            System.out.println(person.getLastName());
            System.out.println(person.getPhoneNumber());
            List<Address> addresses = person.getAddresses().getAddress();
            for(int i=0;i<addresses.size();i++){
                System.out.println(addresses.get(i).getNumber()+" "+addresses.get(i).getStreet());
            }

            person.setFirstName("jojo");
            person.setLastName("ahmed");

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(person,new File("person.xml"));


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
