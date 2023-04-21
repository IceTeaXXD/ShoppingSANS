package com.mycompany.JualBarang;

import java.util.ArrayList;

/**
 *
 * @author Azmi Hasna Zahrani - 13521006
 */

public class InventoryBarang<T>{
    private ArrayList <T> Inventory;

    public InventoryBarang(){
        Inventory = new ArrayList<>();
    }
    
    public void addBarang(T barang, int index){
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

    public void updateBarang(T barang, int index){
        Inventory.set(index, barang);
    }
}