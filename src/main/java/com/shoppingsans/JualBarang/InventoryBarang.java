package com.shoppingsans.JualBarang;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Azmi Hasna Zahrani - 13521006
 * @author Matthew Mahendra - 13521007
 * {@summary Container untuk barang-barang yang tersedia. Menyimpan objek Barang}
 */

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "InventoryBarang")
@XmlAccessorType(XmlAccessType.FIELD)
public class InventoryBarang implements Serializable{
    @XmlElement(name = "Barang")
    private ArrayList <Barang> Inventory = new ArrayList<>();

    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
    )
    
    @JsonIgnore
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

    @JsonIgnore
    public ArrayList<Barang> getBarang() {
        return Inventory;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        InventoryBarang other = (InventoryBarang) obj;
        return Inventory.equals(other.getInventory());
    }
}