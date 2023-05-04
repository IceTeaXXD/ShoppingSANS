/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.files;

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
    private final OBJtoJSON oj = new OBJtoJSON();
    private final JSONtoOBJ jo = new JSONtoOBJ();
    private final XMLtoOBJ xo = new XMLtoOBJ();
    private final OBJtoXML ox = new OBJtoXML();
    private final ObjectToOBJ oobj = new ObjectToOBJ();
    private final OBJToObject objo = new OBJToObject();
    
    public DataStore() throws JAXBException, IOException, FileNotFoundException, ClassNotFoundException{
        /* Baca file xml users dan inventory barang */
        config = xo.convert(Config.class, "./src/main/java/com/shoppingsans/files/Config.xml");
        if(config.getSaveas().equals("xml")){
            users = xo.convert(User.class, "./src/main/java/com/shoppingsans/files/Customers.xml");
            inventoryBarang = xo.convert(InventoryBarang.class, "./src/main/java/com/shoppingsans/files/Barang.xml");
        }else if (config.getSaveas().equals("json")){
            users = jo.convert(User.class, "./src/main/java/com/shoppingsans/files/Customers.json");
            inventoryBarang = jo.convert(InventoryBarang.class, "./src/main/java/com/shoppingsans/files/Barang.json");
        }else if(config.getSaveas().equals("obj")){
            users = objo.convert(User.class, "./src/main/java/com/shoppingsans/files/Customers.OBJ");
            inventoryBarang = objo.convert(InventoryBarang.class, "./src/main/java/com/shoppingsans/files/Barang.OBJ");
        }
    }
    
    public void saveAs() throws JAXBException, FileNotFoundException{
        if(config.getSaveas().equals("xml")){
            ox.convert(users, "./src/main/java/com/shoppingsans/files/Customers.xml");
            ox.convert(inventoryBarang, "./src/main/java/com/shoppingsans/files/Barang.xml");
        }else if(config.getSaveas().equals("json")){
            oj.convert(users, "./src/main/java/com/shoppingsans/files/Customers.json");
            oj.convert(inventoryBarang, "./src/main/java/com/shoppingsans/files/Barang.json");
        }else if(config.getSaveas().equals("obj")){
            oobj.convert(users, "./src/main/java/com/shoppingsans/files/Customers.OBJ");
            oobj.convert(inventoryBarang, "./src/main/java/com/shoppingsans/files/Barang.OBJ");
        }
        
        ox.convert(config, "./src/main/java/com/shoppingsans/files/Config.xml");
    }
}
