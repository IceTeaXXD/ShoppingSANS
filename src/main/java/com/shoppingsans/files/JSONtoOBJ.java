package com.shoppingsans.files;

import java.nio.file.Files;  
import java.nio.file.Paths;  
import org.json.JSONException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONtoOBJ implements Converter{
    @Override
    public void convert(String path, String output) {
        try{
            String jsonString;
            jsonString = new String(Files.readAllBytes((Paths.get(path))));
            System.out.println(jsonString);
            Gson gsonBuilder = new GsonBuilder().create();
            // DataStore Data = gsonBuilder.fromJson(jsonString, DataStore.class);
        }catch (JSONException e) {  
            // TODO: handle exception  
            System.out.println(e.toString());  
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        JSONtoOBJ jx = new JSONtoOBJ();
        jx.convert("./src/main/java/com/shoppingsans/files/Config.json", "blablabla.xml");
    }
}
