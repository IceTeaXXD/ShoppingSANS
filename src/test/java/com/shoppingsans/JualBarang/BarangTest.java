/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.shoppingsans.JualBarang;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Azmi Hasna Zahrani
 */
public class BarangTest {
    Barang b;
    
    @Before
    public void setUp() {
        b = new Barang(1, "Gula", 15000, 10, 1000, "Makanan", "Gula.jpg");
                
    }
    
    @Test
    public void testgetId(){
        assertEquals(1, b.getIdBarang());
    }
    
    @Test
    public void testgetNama(){
        assertEquals((String)"Gula", b.getNamaBarang());
    }
    
    @Test
    public void testgethargaBarang(){
        assertEquals(15000, b.getHargaBarang());
    }
    
    @Test
    public void testgetStok(){
        assertEquals(10, b.getStokBarang());
    }
    
    @Test
    public void testgetKategori(){
        assertEquals((String)"Makanan", b.getKategori());
    }
    
    @Test
    public void testgetGambar(){
        assertEquals((String)"Gula.jpg", b.getGambar());
    }
}
