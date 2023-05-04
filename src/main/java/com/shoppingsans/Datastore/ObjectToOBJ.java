/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Datastore;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Matthew
 */
public class ObjectToOBJ implements Converter{

    @Override
    public void convert(Object o, String file) throws JAXBException, FileNotFoundException {
        FileOutputStream f = new FileOutputStream(file);
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream (f);
            out.writeObject(o);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(ObjectToOBJ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
