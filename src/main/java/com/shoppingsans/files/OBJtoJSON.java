/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.files;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matthew
 */
public class OBJtoJSON implements Converter{

    @Override
    public void convert(Object o, String file) {
        ObjectMapper mapper = new ObjectMapper();
        String json ="";
        try {
            json = mapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(o);
                            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(OBJtoJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        FileWriter writer;
        try {
            writer = new FileWriter(file);
            writer.write(json);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(OBJtoJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
