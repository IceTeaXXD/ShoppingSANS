/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.User;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 *
 * @author Matthew Mahendra - 13521007
 */
@Setter
@Getter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("VIP")
public class VIP extends Customer implements Diskon {
    @XmlElement(name = "nama")
    @NonNull protected String nama;
    @XmlElement(name = "notelp")
    @NonNull protected String notelp;
    @XmlElement(name = "poin")
    @NonNull protected Integer poin;
    @XmlElement(name="isActive")
    @NonNull protected Boolean isActive;
    
    public VIP(Integer id, String nama, String notelp, Integer poin){
        super(id);
        this.nama = nama;
        this.notelp = notelp;
        this.poin = poin;
        this.isActive = true;
    }
    
    @Override
    public double calculateDiskon(int price){
        int temp = (int) ((price*0.9) >= poin ? poin : (price*0.9));
        this.poin = price >= poin ? 0 : poin - price;
        return ((int) price*0.9) - temp;
    }
    
    @Override
    public Integer applyDiskon(int price){
        return ((int) (price*0.9));
    }
    
    @Override
    public void setPoin(int price){
        double temp = price * 0.01;
        Integer pointtemp = (int) temp;
        this.poin = pointtemp;
    }
    
    public void deactivate(){
        this.isActive = false;
    }
    
    /* Tester Class */
    public static void main(String[] args){
        Customer c = new Member(3, "0833444555","Skakmat", 0);
        /* Casting */
        Member m = (Member) c;
        
        /* Test */
        System.out.println(m.getId());
        System.out.println(m.getNama());
        System.out.println(m.getPoin());
    }
}
