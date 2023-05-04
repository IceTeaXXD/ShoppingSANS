/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.files;

import com.shoppingsans.User.Member;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Matthew Mahendra - 13521007
 */
public class Driver {
    public static void main(String[] args) throws JAXBException, FileNotFoundException, IOException {
        DataStore ds = new DataStore();
        
        Member m = new Member(6, "Bintang", "0811222222", 30);
        
        ds.getConfig().setSaveas("json");
        
        ds.getUsers().getCustomers().add(m);
        
        ds.saveAs();
    }
}
