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
public class FixedBillTest {
    
    private FixedBill fb;
    
    @Before
    public void setUp() {
        fb = new FixedBill(1, 3);
    }
    
    @Test
    public void testid(){
        assertEquals((Integer)1, fb.getId());
    }
    
    @Test
    public void testidUser(){
        assertEquals((Integer)3, fb.getIdUser());
    }
}
