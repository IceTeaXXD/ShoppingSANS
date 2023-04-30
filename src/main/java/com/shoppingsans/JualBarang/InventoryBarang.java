package com.shoppingsans.JualBarang;

import java.util.ArrayList;

/**
 *
 * @author Azmi Hasna Zahrani - 13521006
 * @author Matthew Mahendra - 13521007
 * {@summary Container untuk barang-barang yang tersedia. Menyimpan objek Barang}
 */

public class InventoryBarang{
    private final ArrayList <Barang> Inventory;

    public InventoryBarang(){
        Inventory = new ArrayList<>();
    }

    public void addBarang(Barang barang){
        Inventory.add(barang);
    }

    public void addBarang(Barang barang, int index){
        Inventory.add(index, barang);
    }

    public void readInventory(){
        for (int i = 0; i < Inventory.size(); i++){
            System.out.println(Inventory.get(i));
        }
    }

    public void readInventory(int index){
        System.out.println(Inventory.get(index));
    }

    public void removeBarang(int index){
        Inventory.remove(index);
    }

    public void updateBarang(Barang barang, int index){
        Inventory.set(index, barang);
    }
}