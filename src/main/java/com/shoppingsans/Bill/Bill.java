/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Bill;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ahmad Nadil - 13521024
 * @author Matthew Mahendra - 13521007
 * {@summary Bill yang dapat dimodify}
 */
@Getter
@Setter
public class Bill extends FixedBill{
    public Bill(Integer id, Integer userID) {
        super(id, userID);
    }
    
    public void addBarang(String barang, Integer jumlah, Integer hargaSatuan) {
        if (mapPembelian.containsKey(barang)) {
            Integer temp = mapPembelian.get(barang);
            temp += jumlah;
            total += jumlah * hargaSatuan;
            mapPembelian.put(barang, temp);
        } else {
            mapPembelian.put(barang, jumlah);
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