package com.shoppingsans.JualBarang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Azmi Hasna Zahrani - 13521006
 * @author Matthew Mahendra - 13521007
 * {@summary Container untuk barang-barang yang tersedia. Menyimpan objek Barang}
 */

@Getter
@Setter
@AllArgsConstructor
@XmlRootElement(name = "InventoryBarang")
public class InventoryBarang{
    @XmlElement(name = "Barang")
    private final ArrayList <Barang> Inventory;

    public InventoryBarang(){
        Inventory = new ArrayList<>();
    }

    public int getSize(){
        return Inventory.size();
    }
    public void addBarang(Barang barang){
        Inventory.add(barang);
    }

    public void addBarang(Barang barang, int index){
        Inventory.add(index, barang);
    }

    public void readInventory(){
        for (int i = 0; i < Inventory.size(); i++){
            System.out.println(Inventory.get(i).getNamaBarang());
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

    public Barang[] getBarang() {
        return Inventory.toArray(new Barang[0]);
    }
}