package com.shoppingsans.JualBarang;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.shoppingsans.Bill.Bill;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.annotation.processing.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Bintang Hijriawan - 13521003
 */
@Data
@NoArgsConstructor
@XmlRootElement (name = "Bills")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bills implements Serializable{
    @XmlElement (name = "Bill")
    private ArrayList<Bill> listBill = new ArrayList<>();

    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
    )

    // public History() {
    //     this.listBill = new ArrayList<>();
    // }
    
    @JsonIgnore
    public int getSize() {
        // System.out.println(listBill.get(0).getEntries().size());
        return listBill.size();
    }
    public void addBill(Bill bill) {
        listBill.add(bill);
    }

    public void removeBill(Bill bill) {
        listBill.remove(bill);
    }

    public void createEntryLists() {
        for (Bill bill : listBill)
        {
            // System.out.println("Vall");
            bill.createEntryList();
        }
    }
    public void createMapBill(InventoryBarang inventoryBarang) {
        int i = 0;
        for (Bill bill : listBill)
        {
            // System.out.println("i:"+i++);
            int j = 0;
            if (bill.getPembelian().getEntry()!=null)
            bill.createMap();
            for (Barang barang : inventoryBarang.getBarang())
            {
                bill.createMapId(barang);
            }
        }
    }

    public void printListBill() {
        for (Bill bill : listBill) {
            bill.printItems();
        }
    }
}
