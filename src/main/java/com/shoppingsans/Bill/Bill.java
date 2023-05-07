/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Bill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.shoppingsans.JualBarang.Barang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Ahmad Nadil - 13521024
 * @author Matthew Mahendra - 13521007
 * {@summary Bill yang dapat dimodify}
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonTypeName("Bill")
public class Bill extends FixedBill {
    

    @JsonIgnore
    @XmlTransient
    private HashMap<Integer, String> mapId = new HashMap<>();

    @JsonIgnore
    @XmlTransient
    protected String datetime;

    public Bill(Integer id, Integer userID) {
        super(id, userID);
    }
    
    public void createMapId(Barang barang) {
        mapId.put(barang.getIdBarang(), barang.getNamaBarang());
    }

    public void createEntryList() {

        this.getPembelian().setEntry(new ArrayList<>());
        for (Map.Entry<String,Integer> entry : this.getMapPembelian().entrySet())
        {
            this.getPembelian().getEntry().add(new Entry(entry.getKey(), entry.getValue()));
        }
        // System.out.println(getPembelian());
    }

    public void addBarang(String barang, Integer jumlah, Integer hargaSatuan) {
        if (mapPembelian.containsKey(barang)) {
            Integer temp = mapPembelian.get(barang);
            temp += jumlah;
            total += jumlah * hargaSatuan;
            mapPembelian.put(barang, temp);
        } else {
            mapPembelian.put(barang, jumlah);
            total += jumlah * hargaSatuan;
        }
    }

    public void removeBarang(String barang, Integer jumlah, Integer hargaSatuan) {
        if (mapPembelian.containsKey(barang)) {
            Integer temp = mapPembelian.get(barang);
            temp -= jumlah;
            total -= jumlah * hargaSatuan;
            if (temp == 0) {
                mapPembelian.remove(barang);
            } else {
                mapPembelian.put(barang, temp);
            }
        }
    }
}