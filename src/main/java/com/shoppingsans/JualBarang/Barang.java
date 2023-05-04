package com.shoppingsans.JualBarang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Azmi Hasna Zahrani - 13521006
 */

@Getter
@Setter
@AllArgsConstructor
public class Barang {
    private String namaBarang;
    private int hargaBarang;
    private int stokBarang;
    private int hargaBeli;
    private String kategori;
    private String gambar;

    public Barang(){
        namaBarang = "";
        hargaBarang = 0;
        stokBarang = 0;
        hargaBeli = 0;
        kategori = "";
        gambar = "";
    }
}