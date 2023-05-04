/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.files;

import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Matthew Mahendra - 13521007
 */
public class Driver {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        XMLtoJSON xj = new XMLtoJSON();
        // JSONtoXML jx = new JSONtoXML();
        OBJtoXML ox = new OBJtoXML();
        xj.convert("./src/main/java/com/shoppingsans/files/Config.xml", "Config.json");
        // jx.convert("./src/main/java/com/shoppingsans/files/tesJSON.json", "tesOutputXML.xml");
        Person p = new Person(19, "Mahen");
        System.out.println(p.getName());
        ox.convert(p, "./src/main/java/com/shoppingsans/files/Person.xml");
    }
}
