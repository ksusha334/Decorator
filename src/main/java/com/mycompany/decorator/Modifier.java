/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.decorator;

/**
 *
 * @author march
 */
public abstract class Modifier extends Dish {
    protected Dish dish;
    
    public Modifier(Dish dish) {
        this.dish = dish;
    }
    
    @Override
    public String getDescription() {
        return dish.getDescription();
    }
    
    @Override
    public int getPrice() {
        return dish.getPrice();
    }
}