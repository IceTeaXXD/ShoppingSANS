/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Datastore;

import com.shoppingsans.JualBarang.History;
import com.shoppingsans.Bill.Bill;
import com.shoppingsans.JualBarang.Bills;
import com.shoppingsans.JualBarang.InventoryBarang;
import com.shoppingsans.User.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import javax.xml.crypto.Data;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Matthew
 */
@Getter
@Setter
public class DataStore {
    private Config config;
    private User users;
    private InventoryBarang inventoryBarang;
    private History history;
    private Bills bills;
    
    /* Converters */
    private final JSONAdapter ja = new JSONAdapter();
    private final XMLAdapter xa = new XMLAdapter();
    private final OBJAdapter oa = new OBJAdapter();
    
    public DataStore() throws JAXBException, IOException, FileNotFoundException, ClassNotFoundException{
        /* Baca file xml users dan inventory barang */
        config = xa.load(Config.class, "./src/main/java/com/shoppingsans/Datastore/Config.xml");
        if(config.getSaveas().equals("xml")){
            users = xa.load(User.class, config.getPath()+"Customers.xml");
            inventoryBarang = xa.load(InventoryBarang.class, config.getPath()+"Barang.xml");
            bills = xa.load(Bills.class, config.getPath()+"Bills.xml");
            history = xa.load(History.class, config.getPath()+"History.xml");
            bills.createMapBill(inventoryBarang);
            history.createMapFixedBill();
        }else if (config.getSaveas().equals("json")){
            users = ja.load(User.class, config.getPath()+"Customers.json");
            inventoryBarang = ja.load(InventoryBarang.class, config.getPath()+"Barang.json");
            bills = ja.load(Bills.class, config.getPath()+"Bills.json");
            history = ja.load(History.class, config.getPath()+"History.json");
            bills.createMapBill(inventoryBarang);
            history.createMapFixedBill();
        }else if(config.getSaveas().equals("obj")){
            users = oa.load(User.class, config.getPath()+"Customers.OBJ");
            inventoryBarang = oa.load(InventoryBarang.class, config.getPath()+"Barang.OBJ");
            bills = oa.load(Bills.class, config.getPath()+"Bills.OBJ");
            history = oa.load(History.class, config.getPath()+"History.OBJ");
            bills.createMapBill(inventoryBarang);
            history.createMapFixedBill();
        }
    }
    
    public void saveAs() throws JAXBException, FileNotFoundException{
        bills.createEntryLists();
        // System.out.println("-------------aaaaaaaaaaa-----------");
        // System.out.println(config.getSaveas());
        // System.out.println(bills);
        int i = 0;
        // for (Bill bill : bills.getListBill())
        // {
        //     System.out.println("-----------" + i++);
        //     System.out.println(bill.getMapPembelian());
        //     System.out.println(bill.getPembelian());
        // }
        // System.out.println("-------------aaaaaaaaaaa-----------");
        if(config.getSaveas().equals("xml")){
            xa.convert(users, config.getPath()+"Customers.xml");
            xa.convert(inventoryBarang, config.getPath()+"Barang.xml");
            xa.convert(history, config.getPath()+"History.xml");
            xa.convert(bills, config.getPath()+"Bills.xml");
        }else if(config.getSaveas().equals("json")){
            ja.convert(users, config.getPath()+"Customers.json");
            ja.convert(inventoryBarang, config.getPath()+"Barang.json");
            ja.convert(history, config.getPath()+"History.json");
            ja.convert(bills, config.getPath()+"Bills.json");
        }else if(config.getSaveas().equals("obj")){
            oa.convert(users, config.getPath()+"Customers.OBJ");
            oa.convert(inventoryBarang, config.getPath()+"Barang.OBJ");
            oa.convert(history, config.getPath()+"History.OBJ");
            oa.convert(bills, config.getPath()+"Bills.OBJ");
        }
        
        // xa.convert(config, "./src/main/java/com/shoppingsans/Datastore/Config.xml");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        DataStore other = (DataStore) obj;
        return inventoryBarang.equals(other.getInventoryBarang());
    }
}
