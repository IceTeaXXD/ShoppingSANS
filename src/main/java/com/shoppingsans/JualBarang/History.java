/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.JualBarang;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.shoppingsans.Bill.Entry;
import com.shoppingsans.Bill.FixedBill;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ahmad Nadil - 13521024
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement (name = "History")
@XmlAccessorType(XmlAccessType.FIELD)

public class History implements Serializable{
    @XmlElement (name = "FixedBill")
    private ArrayList<FixedBill> listHistory;

    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
    )

    // public History() {
    //     this.listHistory = new ArrayList<>();
    // }

    @JsonIgnore
    public int getSize() {
        // System.out.println(listHistory.get(0).getEntries().size());
        return listHistory.size();
    }
    public void addHistory(FixedBill bill) {
        listHistory.add(bill);
    }

    public void removeHistory(FixedBill bill) {
        listHistory.remove(bill);
    }

    public void createMapFixedBill() {
        for (FixedBill fixedBill : listHistory)
            fixedBill.createMap();
    }

    public void printListHistory() {
        for (FixedBill bill : listHistory) {
            bill.printItems();
        }
    }
}


// import java.util.List;
// import javax.xml.bind.annotation.*;

// @Data
// @NoArgsConstructor
// @XmlRootElement(name = "History")
// @XmlAccessorType(XmlAccessType.FIELD)
// public class History {
//     @XmlElement(name = "FixedBill")
//     private List<FixedBill> fixedBills;

// }