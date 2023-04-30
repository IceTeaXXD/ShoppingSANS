package com.shoppingsans.files;

import com.shoppingsans.JualBarang.Barang;
import com.shoppingsans.JualBarang.History;
import com.shoppingsans.JualBarang.InventoryBarang;
import java.util.*;
import com.shoppingsans.User.Customer;
import com.shoppingsans.User.Member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class DataStore {
    String matauang;
    String tipeFileConfig;
    InventoryBarang listBarang;
    ArrayList<Customer> listCustomer;
    ArrayList<History> listHistory;

    public DataStore(){
        this.listBarang = new InventoryBarang();
        this.listCustomer = new ArrayList<>();
        this.listHistory = new ArrayList<>();
    }

    public void displayBarang()
    {
        listBarang.readInventory();
    }
    public void displayListCustomer()
    {
        System.out.println("List Customer : ");
        for (int i = 0; i < listCustomer.size(); i++)
        {
            System.out.println(listCustomer.get(i).getId());
        }
    }

    public Customer testCust(String path) throws FileNotFoundException {
        Customer x = new Customer(0);
        File fileXML = new File(path);
        Scanner xml = new Scanner(fileXML);
        String temp;
        while(xml.hasNextLine()){
            temp = xml.nextLine();
            String cust = temp;
            temp = xml.nextLine();
            while (!temp.replaceAll("\\s+","").equals("</Customer>")){
                cust += temp;
                System.out.println(temp);
                temp = xml.nextLine();
            }
            cust += temp;
            System.out.println(cust);
            JAXBContext jaxbContext;
            try
            {
                jaxbContext = JAXBContext.newInstance(Customer.class);        
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                Customer customer = (Customer) jaxbUnmarshaller.unmarshal(new StringReader(cust));
                this.listCustomer.add(customer);
                return customer;
            }
            catch (JAXBException e) 
            {
                e.printStackTrace();
            }
        }
        return x;
    }

    public void readXML(String path) throws FileNotFoundException {
        String temp;
        File fileXML = new File(path);
        Scanner xml = new Scanner(fileXML);
        // BufferedReader br = new BufferedReader(new FileReader(fileXML));
        //output xml
        // String firstLine = xml.nextLine();
        // System.out.println("First Line : ");
        // System.out.println(firstLine);
        // String ttemp = xml.nextLine();
        // System.out.println("Second Line : ");
        // System.out.println(ttemp);
        // remove spacing in ttemp
        while(xml.hasNextLine()){
            temp = xml.nextLine();
            // System.out.println(temp);
            // temp = temp.replaceAll("\\s+","");
            // System.out.println(temp);
            if (temp.replaceAll("\\s+","").equals("<User>")) {
                while (!temp.replaceAll("\\s+","").equals("</User>")){
                    if (temp.replaceAll("\\s+","").equals("<Customer>")){
                        String cust = temp;
                        temp = xml.nextLine();
                        while (!temp.replaceAll("\\s+","").equals("</Customer>")){
                            cust += temp;
                            System.out.println(temp);
                            temp = xml.nextLine();
                        }
                        cust += temp;
                        System.out.println("|||||||||||||||||||");
                        System.out.println(cust);
                        JAXBContext jaxbContext;
                        try
                        {
                            jaxbContext = JAXBContext.newInstance(Customer.class);        
                            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                            Customer customer = (Customer) jaxbUnmarshaller.unmarshal(new StringReader(cust));
                            this.listCustomer.add(customer);
                        }
                        catch (JAXBException e) 
                        {
                            e.printStackTrace();
                        }
                    }
                    else if (temp.replaceAll("\\s+","").equals("<Member>")) {
                        String memb = temp;
                        temp = xml.nextLine();
                        while (!temp.replaceAll("\\s+","").equals("</Member>")){
                            memb += temp;
                            System.out.println(temp);
                            temp = xml.nextLine();
                        }
                        System.out.println("=======================================================");
                        memb += temp;
                        System.out.println("-------");
                        System.out.println(memb);
                        System.out.println("=======================================================");
                        JAXBContext jaxbContext;
                        try
                        {
                            jaxbContext = JAXBContext.newInstance(Member.class);        
                            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                            Member member = (Member) jaxbUnmarshaller.unmarshal(new StringReader(memb));
                            this.listCustomer.add(member);
                        }
                        catch (JAXBException e) 
                        {
                            e.printStackTrace();
                        }                        
                    }
                    temp = xml.nextLine();
                }

            }
            else if (temp == "<InventoryBarang>") {
                
            }
            else if (temp == "<History>") {
                
            }
        }
        xml.close();
        
    }
        // DataStore ds = new DataStore();
        // try {
        //     ds.readXML("./src/main/java/com/shoppingsans/files/Config.xml");
        // } catch (FileNotFoundException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // ds.displayListCustomer();

    public static void main(String args[])
    {
        DataStore ds = new DataStore();
        try {
            // Customer cst = ds.testCust("./src/main/java/com/shoppingsans/files/customer.xml");
            ds.readXML("./src/main/java/com/shoppingsans/files/Config.xml");
            System.out.println("CEK");
            // System.out.println(cst.getId());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ds.displayListCustomer();
    }
    

}