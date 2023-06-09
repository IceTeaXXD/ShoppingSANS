/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Datastore;

import com.shoppingsans.JualBarang.Barang;
import com.shoppingsans.User.Customer;
import com.shoppingsans.gui.JualBarang;

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
        
        // System.out.println((ds.getBills().getListBill().get(0).getMapId()));
        for(int i = 0; i < ds.getBills().getListBill().size(); i++) {
            System.out.println((ds.getBills().getListBill().get(i).getMapId()));
        }
        // Barang b = new Barang();
        // b.setNamaBarang("Mouse");
        // b.setHargaBarang(900000);
        // b.setHargaBeli(50000);
        // b.setKategori("Elektronik");
        // b.setStokBarang(10);
        // b.setGambar("mouse.jpg");
        // b.setIdBarang(ds.getInventoryBarang().getSize() + 1);
        
        ds.getConfig().getMapKurs().put("JPY", 100);

        System.out.println(ds.getConfig());
//        ds.getInventoryBarang().getInventory().add(b);
        ds.saveAs();
        
        // ds.getConfig().setSaveas("json");
        // ds.saveAs();
        
        ds.getConfig().setSaveas("obj");
        ds.saveAs();

        ds.getConfig().setSaveas("xml");
        ds.saveAs();
    }
}
