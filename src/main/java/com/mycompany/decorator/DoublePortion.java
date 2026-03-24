/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.decorator;

/**
 *
 * @author march
 */
public class DoublePortion extends Modifier {
    public DoublePortion(Dish dish) {
        super(dish);
    }
    
    @Override
    public String getDescription() {
        return dish.getDescription() + " + двойная порция";
    }
    
    @Override
    public int getPrice() {
        return dish.getPrice() + 20;
    }
}
