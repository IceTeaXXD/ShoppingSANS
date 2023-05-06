/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Datastore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;

/**
 *
 * @author Matthew
 */
public class JSONAdapter implements Adapter {

    @Override
    public void convert(Object o, String file) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(o);
            
            FileWriter writer;
            writer = new FileWriter(file);
            writer.write(json);
            writer.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(JSONAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSONAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public <T> T load(Class<T> clazz, String file) throws JAXBException, FileNotFoundException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(file), clazz);
    }
    
}
