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
public class JSONtoXML implements Converter {

    @Override
    public void convert(String path, String output) {
        try{
            File fileXML = new File(path);
            Scanner xml = new Scanner(fileXML);
            String jsonString = "";
            while(xml.hasNextLine()){
                jsonString += xml.nextLine();
            }
            JSONObject json = new JSONObject(jsonString);
            String saveXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + XML.toString(json);
            System.out.println(saveXML);
            FileWriter myWriter = new FileWriter("./src/main/java/com/shoppingsans/files/" + output);
            myWriter.write(saveXML);
            myWriter.close();
        }catch (JSONException e) {  
            // TODO: handle exception  
            System.out.println(e.toString());  
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
