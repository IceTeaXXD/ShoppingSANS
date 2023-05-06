/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Datastore;

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
    
    /* Converters */
    private final JSONAdapter ja = new JSONAdapter();
    private final XMLAdapter xa = new XMLAdapter();
    private final OBJAdapter oa = new OBJAdapter();
    
    public DataStore() throws JAXBException, IOException, FileNotFoundException, ClassNotFoundException{
        /* Baca file xml users dan inventory barang */
        config = xa.load(Config.class, "./src/main/java/com/shoppingsans/Datastore/Config.xml");
        if(config.getSaveas().equals("xml")){
            users = xa.load(User.class, "./src/main/java/com/shoppingsans/Datastore/Customers.xml");
            inventoryBarang = xa.load(InventoryBarang.class, "./src/main/java/com/shoppingsans/Datastore/Barang.xml");
        }else if (config.getSaveas().equals("json")){
            users = ja.load(User.class, "./src/main/java/com/shoppingsans/Datastore/Customers.json");
            inventoryBarang = ja.load(InventoryBarang.class, "./src/main/java/com/shoppingsans/Datastore/Barang.json");
        }else if(config.getSaveas().equals("obj")){
            users = oa.load(User.class, "./src/main/java/com/shoppingsans/Datastore/Customers.OBJ");
            inventoryBarang = oa.load(InventoryBarang.class, "./src/main/java/com/shoppingsans/Datastore/Barang.OBJ");
        }
    }
    
    public void saveAs() throws JAXBException, FileNotFoundException{
        if(config.getSaveas().equals("xml")){
            xa.convert(users, "./src/main/java/com/shoppingsans/Datastore/Customers.xml");
            xa.convert(inventoryBarang, "./src/main/java/com/shoppingsans/Datastore/Barang.xml");
        }else if(config.getSaveas().equals("json")){
            ja.convert(users, "./src/main/java/com/shoppingsans/Datastore/Customers.json");
            ja.convert(inventoryBarang, "./src/main/java/com/shoppingsans/Datastore/Barang.json");
        }else if(config.getSaveas().equals("obj")){
            oa.convert(users, "./src/main/java/com/shoppingsans/Datastore/Customers.OBJ");
            oa.convert(inventoryBarang, "./src/main/java/com/shoppingsans/Datastore/Barang.OBJ");
        }
        
        xa.convert(config, "./src/main/java/com/shoppingsans/Datastore/Config.xml");
    }
}
