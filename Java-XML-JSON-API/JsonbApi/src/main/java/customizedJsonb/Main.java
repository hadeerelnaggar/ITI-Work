package customizedJsonb;

import jsonb.Dog;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("tito",10,"white");

        Jsonb jsonb = JsonbBuilder.create();
        String result = jsonb.toJson(cat);

        System.out.println(result);

        Cat cat2 = jsonb.fromJson(result, Cat.class);
        System.out.println(cat2.name + " " + cat2.age + " " + cat2.color);
    }

}

