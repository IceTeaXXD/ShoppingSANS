/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.shoppingsans.JualBarang;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Azmi Hasna Zahrani
 */
public class InventoryBarangTest {
    
    private InventoryBarang Inventory;
    private Barang a;
    private Barang b;
    
    @Before
    public void setUp() {
        Inventory = new InventoryBarang();
        a = new Barang(2, "Teh", 5000, 5, 10000, "Makanan", "teh.jpg");
        b = new Barang(1, "Gula", 15000, 10, 1000, "Makanan", "Gula.jpg");
        
    }
    
    @Test
    public void testaddBarang(){
        Inventory.addBarang(a);
        assertEquals(1, Inventory.getSize());
    }
    
    @Test
    public void testgetSize(){
        Inventory.addBarang(b);
        assertEquals(1, Inventory.getSize());
    }
    
    
    @Test
    public void testremoveBarang(){
        Inventory.addBarang(a,0);
        Inventory.addBarang(b,1);
        Inventory.removeBarang(1);
        assertEquals(1, Inventory.getSize());
    }
    
    @Test
    public void testUpdateBarang(){
        Inventory.addBarang(a,0);
        Inventory.updateBarang(b, 0);
        assertEquals(1, Inventory.getSize());
    }
    
    @Test
    public void testgetBarang(){
        Inventory.addBarang(a);
        assertEquals((String)"[Barang(idBarang=2, namaBarang=Teh, hargaBarang=5000, stokBarang=5, hargaBeli=10000, kategori=Makanan, gambar=teh.jpg)]", Inventory.getBarang().toString());
    }
    
    @Test
    public void testequals(){
        Inventory.addBarang(a);
        assertEquals(false, Inventory.equals(a));
    }

    @Test
    public void testgetInventory(){
        Inventory.addBarang(a);
        assertEquals((String)"[Barang(idBarang=2, namaBarang=Teh, hargaBarang=5000, stokBarang=5, hargaBeli=10000, kategori=Makanan, gambar=teh.jpg)]", Inventory.getInventory().toString());
    }
}
