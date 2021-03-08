package codeFirst;

public class Address {
    private int number;
    private String street;

    Address(){

    }

    public Address(int number, String street) {
        this.number = number;
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "number=" + number +
                ", street='" + street + '\'' +
                '}';
    }
}
