/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.files;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

/**
 *
 * @author Matthew
 */
public class XMLtoJSON implements Converter {

    @Override
    public void convert(String path, String output) {
        try{
            File fileXML = new File(path);
            Scanner xml = new Scanner(fileXML);
            String xmlString = "";
            while(xml.hasNextLine()){
                xmlString += xml.nextLine();
            }
            JSONObject jsonString = XML.toJSONObject(xmlString);
            System.out.println(jsonString);  

            FileWriter myWriter = new FileWriter("./src/main/java/com/shoppingsans/files/" + output);
            myWriter.write(jsonString.toString());
            myWriter.close();
        }catch (JSONException e) {  
            // TODO: handle exception  
            System.out.println(e.toString());  
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
