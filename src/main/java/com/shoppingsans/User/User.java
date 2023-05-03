package com.shoppingsans.User;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bintang Hijriawan - 13521003
 */

@XmlRootElement(name = "User")
public class User {
    @XmlElement(name = "Customer")
    private ArrayList<Customer> customers;
    @XmlElement(name = "Member")
    private ArrayList<Member> members;

    public User(){
        this.customers = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }
}
