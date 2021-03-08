package jsonb;

public class Dog {
    public String name=null;
    public int age;
    public boolean bitable;

    public Dog(){

    }

    public Dog(String name, int age, boolean bitable) {
        this.name = name;
        this.age = age;
        this.bitable = bitable;
    }

    public Dog(int age,boolean bitable) {
        this.bitable = bitable;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", bitable=" + bitable +
                '}';
    }
}
