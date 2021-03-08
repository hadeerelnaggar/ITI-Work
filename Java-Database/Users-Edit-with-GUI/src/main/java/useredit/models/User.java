package useredit.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private StringProperty id=new SimpleStringProperty();
    private StringProperty firstName=new SimpleStringProperty();
    private StringProperty middleName=new SimpleStringProperty();
    private StringProperty lastName=new SimpleStringProperty();
    private StringProperty email=new SimpleStringProperty();
    private StringProperty phone=new SimpleStringProperty();

    public User() {
        id.setValue("123");
        firstName.setValue("");
        lastName.setValue("");
        middleName.setValue("");
        email.setValue("");
        phone.setValue("");
    }
    public User(String id, String firstName, String middleName, String lastName, String email, String phone){
        this.id.setValue(id);
        this.firstName.setValue(firstName);
        this.lastName.setValue(middleName);
        this.middleName.setValue(lastName);
        this.email.setValue(email);
        this.phone.setValue(phone);
    }

    public void setUser(String id, String firstName, String middleName, String lastName, String email, String phone){
        this.id.setValue(id);
        this.firstName.setValue(firstName);
        this.lastName.setValue(middleName);
        this.middleName.setValue(lastName);
        this.email.setValue(email);
        this.phone.setValue(phone);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getMiddleName() {
        return middleName.get();
    }

    public StringProperty middleNameProperty() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName.set(middleName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }
}
