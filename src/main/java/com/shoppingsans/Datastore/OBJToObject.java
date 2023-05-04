/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Datastore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Matthew
 */
public class OBJToObject implements Converter{

    @Override
    public void convert(Object o, String file) throws JAXBException, FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public <T> T convert(Class<T> clazz, String file) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream f = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(f);
        return clazz.cast(in.readObject());
    }
}
