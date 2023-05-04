package com.shoppingsans.files;

import com.shoppingsans.JualBarang.Barang;
import com.shoppingsans.JualBarang.InventoryBarang;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class InventoryBarangParser {
    public static void main(String[] args) {
        try {
            // Create JAXB context and unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(InventoryBarang.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Unmarshal XML file to Java object
            InventoryBarang inventory = (InventoryBarang) jaxbUnmarshaller.unmarshal(new File("Config.xml"));

            // Get array of Barang objects from inventory object
            Barang[] barangArray = inventory.getBarang();

            // Print array elements
            for (Barang barang : barangArray) {
                System.out.println("Nama Barang: " + barang.getNamaBarang());
                System.out.println("Harga Barang: " + barang.getHargaBarang());
                System.out.println("Stok Barang: " + barang.getStokBarang());
                System.out.println("Harga Beli: " + barang.getHargaBeli());
                System.out.println("Kategori: " + barang.getKategori());
                System.out.println("Gambar: " + barang.getGambar());
                System.out.println("--------------");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}