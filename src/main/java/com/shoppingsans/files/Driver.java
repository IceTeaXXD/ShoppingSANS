/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.files;

import com.shoppingsans.JualBarang.Barang;
import com.shoppingsans.User.Customer;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Matthew Mahendra - 13521007
 */
public class Driver {
    public static void main(String[] args) throws JAXBException, IOException, FileNotFoundException, ClassNotFoundException {
        DataStore ds = new DataStore();
        
        ds.getConfig().setSaveas("json");
        
        System.out.println(ds.getUsers().getCustomers().size());
        
//        Customer i = new Customer(5);
        
//        ds.getUsers().getCustomers().add(i);

        Barang b = new Barang();
        b.setNamaBarang("MAHE");
        b.setHargaBarang(10);
        b.setHargaBeli(2);
        b.setKategori("ASD");
        b.setStokBarang(10);
        b.setGambar("ASDSAD.jpg");
        
//        ds.getInventoryBarang().addBarang(b);
        
        for(Customer c : ds.getUsers().getCustomers()){
            System.out.println(c.toString());
        }
        
        
          
        ds.saveAs();
    }
}
