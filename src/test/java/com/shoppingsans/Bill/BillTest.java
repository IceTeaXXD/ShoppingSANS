/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.shoppingsans.Bill;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Azmi Hasna Zahrani
 */
public class BillTest {
    
    Bill b;
    
    @Before
    public void setUp() {
        b = new Bill(6, 9);
    }
    
    @Test
    public void testgetId(){
        assertEquals((Integer) 6, b.getId());
    }
    
    @Test
    public void testgetIdUser(){
        assertEquals((Integer)9, b.getIdUser());
    }
}
