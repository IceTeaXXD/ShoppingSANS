/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.files;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

/**
 *
 * @author Matthew
 * Ini merupakan class template yang bisa diserializable
 */
/* Kasih tau lombok ini data */
@Data
/* Kasih tau nama rootnya kalau jadi XML */
@XmlRootElement(name = "Person")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@Setter
public class Person implements Serializable {
    @XmlElement(name = "age")
    private int age;
    @XmlElement(name = "name")
    private String name;
    Person(){
        /* Konstruktor kosong digunakan untuk binding */
    }
}
