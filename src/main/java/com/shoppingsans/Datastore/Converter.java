/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.shoppingsans.Datastore;

import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Matthew Mahendra - 13521007
 */
public interface Converter {
    public void convert(Object o, String file) throws JAXBException, FileNotFoundException;
}
