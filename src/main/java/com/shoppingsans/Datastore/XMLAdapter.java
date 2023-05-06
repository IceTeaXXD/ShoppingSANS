/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Datastore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Matthew
 */
public class XMLAdapter implements Adapter {
    /**
     * 
     * @param o
     * @param file
     * @throws JAXBException 
     * @throws java.io.FileNotFoundException 
     */
    @Override
    public void convert(Object o, String file) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(o , new FileOutputStream(file));
    }

    
    /**
     * 
     * @param <T>
     * @param clazz
     * @param input
     * @return
     * @throws JAXBException 
     */
    @Override
    public <T> T load(Class<T> clazz, String input) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return clazz.cast(unmarshaller.unmarshal(new File(input)));
    }

}
