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

    @Test
    public void testSetID(){
        this.m.setId(4);
        assertEquals((Integer)4, this.m.getId());
    }

    @Test
    public void testSetNama(){
        this.m.setNama("Metiw");
        assertEquals((String)"Metiw", this.m.getNama());
    }

    @Test
    public void testSetNoTelp(){
        this.m.setNotelp("0889");
        assertEquals((String)"0889", this.m.getNotelp());
    }

    @Test
    public void testSetPoin(){
        this.m.setPoin(0);
        assertEquals((Integer)0, this.m.getPoin());
    }

    @Test
    public void testSetIsActive(){
        this.m.setIsActive(true);
        assertEquals((Boolean)true, this.m.getIsActive());
    }

    @Test
    public void testDeactivate(){
        this.m.deactivate();
        assertEquals((Boolean)false, this.m.getIsActive());
    }

    @Test
    public void testMember(){
        Member m = new Member(3, "Metiw", "0889", 0);
        assertEquals((Integer)3, m.getId());
        assertEquals((String)"Metiw", m.getNama());
        assertEquals((String)"0889", m.getNotelp());
        assertEquals((Integer)0, m.getPoin());
        assertEquals((Boolean)true, m.getIsActive());
    }

    @Test
    public void testApplyDiskon(){
        this.m.applyDiskon(10000);
        assertEquals((Integer)0, this.m.getPoin());
    }
}
