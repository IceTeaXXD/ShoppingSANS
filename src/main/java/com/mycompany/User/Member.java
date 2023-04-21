/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.User;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Matthew Mahendra - 13521007
 */
@Getter
@Setter
public class Member extends Customer implements Diskon {
    protected String nama;
    protected Integer poin;
    
    @Builder
    public Member(Integer id, String nama, Integer poin){
        super(id);
        this.nama = nama;
        this.poin = poin;
    }
    
    @Override
    public double calculateDiskon(int price){
        return price - poin;
    }
    
    @Override
    public void setPoin(int price){
        double temp = price * 0.01;
        Integer pointtemp = (int) temp;
        this.poin = pointtemp;
    }
    
    /* Tester Class */
    public static void main(String[] args){
        Customer c = new Member(3,"Skakmat", 0);
        /* Casting */
        Member m = (Member) c;
        
        /* Test */
        System.out.println(m.getId());
        System.out.println(m.getNama());
        System.out.println(m.getPoin());
    }
}
