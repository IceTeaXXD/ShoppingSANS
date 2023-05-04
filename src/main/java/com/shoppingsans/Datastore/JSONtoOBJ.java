/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Datastore;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Matthew
 */
public class JSONtoOBJ implements Converter {

    @Override
    public void convert(Object o, String file) throws JAXBException, FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public <T> T convert(Class<T> clazz, String file) throws JAXBException, FileNotFoundException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(file), clazz);
    }
    
}
