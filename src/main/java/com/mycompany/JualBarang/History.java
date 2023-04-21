/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JualBarang;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ahmad Nadil - 13521024
 */
@Getter
@Setter
@AllArgsConstructor
public class History {
    private Integer id;
    private String datetime;
    private HashMap<Barang, Integer> pembelian;

    public History(Integer id) {
        this.id = id;
        this.datetime = new Date().toString();
        this.pembelian = new HashMap<>();
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

    public void printHistory() {
        System.out.println("ID Customer: " + id);
        System.out.println("Tanggal: " + datetime);
        System.out.println("Barang yang dibeli: ");
        for (Map.Entry<Barang, Integer> entry : pembelian.entrySet()) {
            System.out.println("Nama Barang: " + entry.getKey().getNamaBarang());
            System.out.println("Jumlah: " + entry.getValue());
        }
    }

    public static void main(String[] args){
        Barang b = new Barang("Sabun", 10000, 10, 5000, "Buku", "buku.jpg");
        Barang b2 = new Barang("Sikat Gigi", 10000, 10, 5000, "Buku", "buku.jpg");
        History h = new History(1);
        h.addBarang(b, 2);
        h.addBarang(b2, 2);
        System.out.println("===== History awal =====");
        h.printHistory();
        h.removeBarang(b, 1);
        System.out.println("===== History setelah menghapus 1 barang =====");
        h.printHistory();
        h.removeBarang(b, 1);
        System.out.println("===== History setelah menghapus 1 barang lagi =====");
        h.printHistory();
    }
}