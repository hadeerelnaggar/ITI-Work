package DomApi;

import javax.json.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            jsonConsumer();
            jsonProducer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void jsonConsumer() throws FileNotFoundException {
        JsonReader jsonReader = Json.createReader(new FileInputStream(new File("person.json")));
        JsonObject person = jsonReader.readObject();
        System.out.println("name:"+person.getString("name"));
        System.out.println("age:"+person.getInt("age"));
        JsonArray addresses = person.getJsonArray("addresses");
        for(int i=0;i<addresses.size();i++) {
            System.out.println("street:"+addresses.getJsonObject(i).getString("street"));
        }
    }

    public static void jsonProducer() throws FileNotFoundException {
        JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(new File("fruits.json")));
        JsonObject jsonObject = Json
                .createObjectBuilder()
                .add("banana","yellow")
                .add("apple","red")
                .add("count",Json.createArrayBuilder()
                        .add(Json.createObjectBuilder().add("apple",4))
                        .add(Json.createObjectBuilder().add("banana",8)))
                .build();
        jsonWriter.writeObject(jsonObject);
        jsonWriter.close();

    }
}
