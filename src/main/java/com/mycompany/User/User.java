/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.User;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Matthew
 */
@Getter
@Setter
public class User implements History{
    private String name;
    
    public User(String name){
        this.name = name;
    }
    
    @Override
    public void getHistory(){
        int x = 0;
        x += 1;
    }
}