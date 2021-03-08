package codeFirst;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "name", "track", "addresses"})
public class Student {
    String name;
    int id;
    String track;
    @XmlElementWrapper(name = "addresses")
    @XmlElement(name = "address")
    List<Address> addresses =new ArrayList<>();

    public Student(){

    }

    public Student(String name, int id, String track, List<Address> addresses) {
        this.name = name;
        this.id = id;
        this.track = track;
        this.addresses = addresses;
    }

    public Student(String name, int id, String track) {
        this.name = name;
        this.id = id;
        this.track = track;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", track='" + track + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
