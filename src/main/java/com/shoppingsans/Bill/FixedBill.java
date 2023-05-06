/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Bill;


import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
// import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 *
 * @author Matthew Mahendra - 13521007
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
public class FixedBill implements Serializable{
    @NonNull
    protected Integer id;
    
    @NonNull
    protected Integer idUser;

    @NonNull
    protected String datetime;

    // @XmlJavaTypeAdapter(FixedBillAdapter.class)
    // @XmlElement(name = "pembelian")
    @JsonIgnore
    @XmlTransient
    protected HashMap<String, Integer> mapPembelian;

    private Pembelian pembelian;
    
    public FixedBill(Integer id, Integer idUser) {
        this.id = id;
        this.idUser = idUser;
        this.datetime = new Date().toString();
        this.pembelian = new Pembelian();
    }

    public void createMap() {
        this.mapPembelian = new HashMap<>();
        for (Entry entry : pembelian.getEntry()) {
            this.mapPembelian.put(entry.getKey(), entry.getValue());
        }
    }

    public void printItems() {
        // System.out.println(entries.size());
        // System.out.println("ID: " + id);
        // System.out.println("ID Customer: " + idUser);
        // System.out.println("Tanggal: " + datetime);
        // System.out.println("Barang yang dibeli: ");
        System.out.println("Fixed Bill ID: " + id);
        System.out.println("User ID: " + idUser);
        System.out.println("Datetime: " + datetime);
        
        for (Map.Entry<String, Integer> entry : mapPembelian.entrySet()) {
            System.out.println("Nama Barang: " + entry.getKey());
            System.out.println("Jumlah: " + entry.getValue());
        }

        System.out.println();
        
    }
}
