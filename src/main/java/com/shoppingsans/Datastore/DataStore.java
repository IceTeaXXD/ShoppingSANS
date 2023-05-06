/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Datastore;

import com.shoppingsans.JualBarang.History;
import com.shoppingsans.JualBarang.InventoryBarang;
import com.shoppingsans.User.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.bind.JAXBException;
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
            history = xa.load(History.class, config.getPath()+"History.xml");
            history.createMapFixedBill();
        }else if (config.getSaveas().equals("json")){
            users = ja.load(User.class, config.getPath()+"Customers.json");
            inventoryBarang = ja.load(InventoryBarang.class, config.getPath()+"Barang.json");
            history = ja.load(History.class, config.getPath()+"History.json");
            history.createMapFixedBill();
        }else if(config.getSaveas().equals("obj")){
            users = oa.load(User.class, config.getPath()+"Customers.OBJ");
            inventoryBarang = oa.load(InventoryBarang.class, config.getPath()+"Barang.OBJ");
            history = oa.load(History.class, config.getPath()+"History.OBJ");
            history.createMapFixedBill();
        }
    }
    
    public void saveAs() throws JAXBException, FileNotFoundException{
        if(config.getSaveas().equals("xml")){
            xa.convert(users, config.getPath()+"Customers.xml");
            xa.convert(inventoryBarang, config.getPath()+"Barang.xml");
            xa.convert(history, config.getPath()+"History.xml");
        }else if(config.getSaveas().equals("json")){
            ja.convert(users, config.getPath()+"Customers.json");
            ja.convert(inventoryBarang, config.getPath()+"Barang.json");
            ja.convert(history, config.getPath()+"History.json");
        }else if(config.getSaveas().equals("obj")){
            oa.convert(users, config.getPath()+"Customers.OBJ");
            oa.convert(inventoryBarang, config.getPath()+"Barang.OBJ");
            oa.convert(history, config.getPath()+"History.OBJ");
        }
        
        xa.convert(config, "./src/main/java/com/shoppingsans/Datastore/Config.xml");
    }
}
