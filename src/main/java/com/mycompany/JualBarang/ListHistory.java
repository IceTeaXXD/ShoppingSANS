/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.JualBarang;
import java.util.*;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ahmad Nadil - 13521024
 */
@Getter
@Setter
public class ListHistory {
    private ArrayList<History> listHistory;

    public ListHistory() {
        this.listHistory = new ArrayList<>();
    }

    public void addHistory(History history) {
        listHistory.add(history);
    }

    public void removeHistory(History history) {
        listHistory.remove(history);
    }

    public void printListHistory() {
        for (History history : listHistory) {
            history.printHistory();
        }
    }
}