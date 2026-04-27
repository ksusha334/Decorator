/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.decorator;

import java.util.ArrayList;

/**
 *
 * @author march
 */
public class BuyHistory {
    private ArrayList<String> history = new ArrayList<>();

    public void add(String text) {
        history.add(text);
    }

    public String getText() {
        return String.join("\n", history);
    }
}
