/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Bill;

import com.shoppingsans.JualBarang.Barang;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 *
 * @author Matthew Mahendra - 13521007
 */
@Getter
@Setter
@AllArgsConstructor
public class FixedBill {
    @NonNull protected Integer id;
    @NonNull protected Integer idUser;
    @NonNull protected String datetime;
    protected HashMap<Barang, Integer> pembelian;
    
    public FixedBill(Integer id, Integer idUser) {
        this.id = id;
        this.idUser = idUser;
        this.datetime = new Date().toString();
        this.pembelian = new HashMap<>();
    }
    
    public void printItems() {
        System.out.println("ID Customer: " + id);
        System.out.println("Tanggal: " + datetime);
        System.out.println("Barang yang dibeli: ");
        for (Map.Entry<Barang, Integer> entry : pembelian.entrySet()) {
            System.out.println("Nama Barang: " + entry.getKey().getNamaBarang());
            System.out.println("Jumlah: " + entry.getValue());
        }
    }
}
