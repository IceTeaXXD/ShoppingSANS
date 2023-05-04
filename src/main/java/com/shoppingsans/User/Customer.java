/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.User;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Matthew
 */
@Getter
@Setter
@AllArgsConstructor
public class Customer{

    protected Integer id;

    public Customer() {
        this.id = -1;
    }

    @XmlElement(name = "id")
    public void setId(Integer id) {
        this.id = id;
    }
    /* Tester Class */
    public static void main(String[] args){
        Customer c = new Customer(3);
        System.out.println(c.getId());
    }
}