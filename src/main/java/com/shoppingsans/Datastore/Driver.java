/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Datastore;

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

        Barang b = new Barang();
        b.setNamaBarang("Mouse");
        b.setHargaBarang(900000);
        b.setHargaBeli(50000);
        b.setKategori("Elektronik");
        b.setStokBarang(10);
        b.setGambar("mouse.jpg");
        b.setIdBarang(ds.getInventoryBarang().getSize() + 1);
        
        ds.getInventoryBarang().getInventory().add(b);
        ds.saveAs();
        
        ds.getConfig().setSaveas("json");
        ds.saveAs();
        
        ds.getConfig().setSaveas("obj");
        ds.saveAs();
    }
}
