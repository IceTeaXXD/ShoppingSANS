package com.shoppingsans.JualBarang;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.shoppingsans.Bill.Bill;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;

import javax.xml.bind.annotation.XmlAccessorType;
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
    private ArrayList<Bill> listBill;

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
    public void addHistory(Bill bill) {
        listBill.add(bill);
    }

    public void removeHistory(Bill bill) {
        listBill.remove(bill);
    }

    public void createMapBill(InventoryBarang inventoryBarang) {
        int i = 0;
        for (Bill bill : listBill)
        {
            System.out.println("i:"+i++);
            int j = 0;
            bill.createMap();
            for (Barang barang : inventoryBarang.getBarang())
            {
                System.out.println("j:"+j++);
                System.out.println(barang);
                bill.createMapId(barang);
            }
            System.out.println("mapId: "+bill.getMapId());
        }
    }

    public void printListHistory() {
        for (Bill bill : listBill) {
            bill.printItems();
        }
    }
}
