/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.shoppingsans.User;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Azmi Hasna Zahrani
 */
public class CustomerTest {
    
    private Customer c;

    @Before
    public void setUp() throws Exception {
        c = new Customer(3);
    }

    @Test
    public void testID(){
        assertEquals((Integer)3, this.c.getId());
    }
    
}
