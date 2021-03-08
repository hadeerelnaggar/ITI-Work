package jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //defaultMappingJsonB();
        //mappingRawCollection();
        mappingAGenericCollection();
    }

    public static void defaultMappingJsonB() {
        Dog dog = new Dog();
        dog.name = "spoty";
        dog.age = 7;
        dog.bitable = false;

        Jsonb jsonb = JsonbBuilder.create();
        String result = jsonb.toJson(dog);

        System.out.println(result);

        Dog dog2 = jsonb.fromJson("{\"name\":\"Spoty\",\"age\":14,\"bitable\":false}", Dog.class);
        System.out.println(dog2.name + " " + dog2.age + " " + dog2.bitable);
    }

    public static void mappingRawCollection() {
        Dog[] dogs = new Dog[]{
                new Dog("spoty", 7, true),
                new Dog("roy", 10, false),
                new Dog("lilly", 5, true)
        };

        JsonbConfig config = new JsonbConfig().withFormatting(true);
        Jsonb jsonb = JsonbBuilder.create(config);
        String result = jsonb.toJson(dogs);

        System.out.println(result);

        dogs = jsonb.fromJson(result, Dog[].class);

        for (int i = 0; i < dogs.length; i++) {
            System.out.println(dogs[i]);
        }

    }

    public static void mappingAGenericCollection() {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("spoty", 7, true));
        dogs.add(new Dog(1,false));

        JsonbConfig config = new JsonbConfig().withNullValues(true);
        Jsonb jsonb = JsonbBuilder.create(config);
        String result  = jsonb.toJson(dogs);

        System.out.println(result);
        dogs=null;
        dogs = jsonb.fromJson(result,new ArrayList<Dog>(){}.getClass().getGenericSuperclass());

        for (Dog dog:
             dogs) {
            System.out.println(dog);
        }
    }
}
