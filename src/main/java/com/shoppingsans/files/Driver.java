/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.files;
/**
 *
 * @author Matthew Mahendra - 13521007
 */
public class Driver {
    public static void main(String[] args) {
        XMLtoJSON xj = new XMLtoJSON();
        JSONtoXML jx = new JSONtoXML();
        xj.convert("./src/main/java/com/shoppingsans/files/tesXML.xml", "tesOutputJSON.json");
        jx.convert("./src/main/java/com/shoppingsans/files/tesJSON.json", "tesOutputXML.xml");
    }
}
