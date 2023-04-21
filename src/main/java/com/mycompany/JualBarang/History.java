/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JualBarang;

import com.mycompany.Bill.FixedBill;
import java.util.*;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ahmad Nadil - 13521024
 */
@Getter
@Setter
public class History {
    private ArrayList<FixedBill> listHistory;

    public History() {
        this.listHistory = new ArrayList<>();
    }

    public void addHistory(FixedBill bill) {
        listHistory.add(bill);
    }

    public void removeHistory(FixedBill bill) {
        listHistory.remove(bill);
    }

    public void printListHistory() {
        for (FixedBill bill : listHistory) {
            bill.printItems();
        }
    }
}