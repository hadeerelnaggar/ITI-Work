package customizedJsonb;

import javax.json.bind.annotation.JsonbNillable;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.config.PropertyOrderStrategy;

@JsonbPropertyOrder(PropertyOrderStrategy.ANY)
public class Cat {
    @JsonbProperty("cat-name")
    String name;
    @JsonbProperty("cat-age")
    int age;
    String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//    @JsonbProperty("cat-age")
    public int getAge() {
        return age;
    }
//    @JsonbProperty("cat's age")
    public void setAge(int age) {
        this.age = age;
    }
    @JsonbTransient
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
