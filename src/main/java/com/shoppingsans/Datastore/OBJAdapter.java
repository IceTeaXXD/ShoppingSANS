/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Datastore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Matthew
 */
public class OBJAdapter implements Adapter{

    @Override
    public void convert(Object o, String file) throws JAXBException, FileNotFoundException {
        FileOutputStream f = new FileOutputStream(file);
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream (f);
            out.writeObject(o);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(OBJAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public <T> T load(Class<T> clazz, String file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(f);
        return clazz.cast(in.readObject());
    }
    
}
