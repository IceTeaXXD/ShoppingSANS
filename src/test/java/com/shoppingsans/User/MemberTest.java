/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.shoppingsans.User;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Azmi Hasna Zahrani
 */
public class MemberTest {
    Customer u;
    Member m;
    
    
    @Before
    public void setUp() {
        u = new Member(3, "Metiw", "0889", 0);
        m = (Member) u;
    }
    
    @Test
    public void testID() {
        assertEquals((Integer)3, this.m.getId());
    }

    @Test
    public void testName(){
        assertEquals((String)"Metiw", this.m.getNama());
    }
    
    @Test
    public void testNoTelp(){
        assertEquals((String)"0889", m.getNotelp());
    }
    
    @Test
    public void testPoin(){
        assertEquals((Integer)0, this.m.getPoin());
    }
}
