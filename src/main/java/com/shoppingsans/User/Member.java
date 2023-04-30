/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.User;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Matthew Mahendra - 13521007
 */
@Getter
@Setter
@XmlRootElement(name = "Member")
public class Member extends Customer implements Diskon {
    protected String nama;
    protected String notelp;
    protected Integer poin;
    protected Boolean isActive;
    public Member() {
        super();
        this.nama = "XX";
        this.notelp = "XX";
        this.poin = 0;
        this.isActive = true;
    }
    @XmlElement(name = "id")
    public void setID(Integer id){
        this.id = id;
    }
    @XmlElement(name = "nama")
    public void setNama(String nama) {
        this.nama = nama;
    }
    @XmlElement(name = "notelp")
    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }
    @XmlElement(name = "poin")
    public void setPoin(Integer poin) {
        this.poin = poin;
    }
    @XmlElement(name = "isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    @Builder
    public Member(Integer id, String nama, String notelp, Integer poin){
        super(id);
        this.nama = nama;
        this.notelp = notelp;
        this.poin = poin;
        this.isActive = true;
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
    
    public void deactivate(){
        this.isActive = false;
    }
    
    /* Tester Class */
    public static void main(String[] args){
        Customer c = new Member(3, "0822333444", "Skakmat", 0);
        /* Casting */
        Member m = (Member) c;
        
        /* Test */
        System.out.println(m.getId());
        System.out.println(m.getNama());
        System.out.println(m.getPoin());
    }
}
