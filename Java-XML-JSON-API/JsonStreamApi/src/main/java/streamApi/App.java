package streamApi;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            jsonConsumer();
            jsonProducer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void jsonConsumer() throws FileNotFoundException {
        JsonParser jsonParser = Json.createParser(new FileInputStream(new File("person.json")));

        while(jsonParser.hasNext()){
            JsonParser.Event event = jsonParser.next();
            switch (event){
                case START_OBJECT:
                    System.out.println("{");
                    break;
                case START_ARRAY:
                    System.out.println("[");
                    break;
                case END_ARRAY:
                    System.out.println("]");
                    break;
                case KEY_NAME:
                case VALUE_STRING:
                    System.out.println(jsonParser.getString());
                    break;
                case END_OBJECT:
                    System.out.println("}");
                    break;
                case VALUE_NUMBER:
                    System.out.println(jsonParser.getInt());
                    break;

            }

        }
        jsonParser.close();
    }

    public static void jsonProducer() throws FileNotFoundException {
        JsonGenerator jsonGenerator = Json.createGenerator(new FileOutputStream(new File("student.json")));

        jsonGenerator.writeStartObject()
                .write("name","hadeer")
                .write("age",22)
                .write("track","java")
                .writeStartArray("addresses")
                .write("dokki")
                .write("maadi")
                .write("elsolimania")
                .writeEnd()
                .writeEnd();
        jsonGenerator.close();

    }
}
