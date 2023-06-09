/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.shoppingsans.JualBarang;

import com.shoppingsans.Bill.FixedBill;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Azmi Hasna Zahrani
 */
public class HistoryTest {
    private History listHistory;
    private FixedBill a;
    private FixedBill b;
    
    @Before
    public void setUp() {
        a = new FixedBill(1, 3);
        b = new FixedBill(2,3);
        listHistory = new History();
    }

    @Test
    public void testaddHistory(){
        listHistory.addHistory(a);
        assertEquals(1, listHistory.getSize());
    }
    
    @Test
    public void testgetSize(){
        listHistory.addHistory(b);
        assertEquals(1, listHistory.getSize());
    }
    
    @Test
    public void testremoveHistory(){
        listHistory.removeHistory(b);
        assertEquals(0,listHistory.getSize());
    }
}
