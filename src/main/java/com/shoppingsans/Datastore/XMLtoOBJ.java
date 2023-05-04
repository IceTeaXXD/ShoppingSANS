/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Datastore;

import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Matthew
 */
public class XMLtoOBJ implements Converter {
    /**
     * 
     * @param <T>
     * @param clazz
     * @param input
     * @return
     * @throws JAXBException 
     */
    public <T> T convert(Class<T> clazz, String input) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return clazz.cast(unmarshaller.unmarshal(new File(input)));
    }

    @Override
    public void convert(Object o, String file) throws JAXBException, FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
