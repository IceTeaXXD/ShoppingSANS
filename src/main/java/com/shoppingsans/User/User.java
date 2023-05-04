package com.shoppingsans.User;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.*;
import javax.xml.bind.annotation.XmlElements;
import lombok.Getter;

/**
 *
 * @author Bintang Hijriawan - 13521003
 */

@XmlRootElement(name = "Users")
@Getter
public class User {
    @XmlElements({
        @XmlElement(name = "Customer", type = Customer.class),
        @XmlElement(name = "Member", type = Member.class),
        @XmlElement(name = "VIP", type = VIP.class)
    })
    private ArrayList<Customer> customers = new ArrayList<>();
    
    public User(){}
}
