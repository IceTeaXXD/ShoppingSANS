/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Bill;

import com.shoppingsans.JualBarang.Barang;
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
    public Bill(Integer id) {
        super(id);
    }
    
    public void addBarang(Barang barang, Integer jumlah) {
        if (pembelian.containsKey(barang)) {
            Integer temp = pembelian.get(barang);
            temp += jumlah;
            pembelian.put(barang, temp);
        } else {
            pembelian.put(barang, jumlah);
        }
    }

    public void removeBarang(Barang barang, Integer jumlah) {
        if (pembelian.containsKey(barang)) {
            Integer temp = pembelian.get(barang);
            temp -= jumlah;
            if (temp == 0) {
                pembelian.remove(barang);
            } else {
                pembelian.put(barang, temp);
            }
        }
    }
}