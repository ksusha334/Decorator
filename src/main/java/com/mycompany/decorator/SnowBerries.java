/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.decorator;

/**
 *
 * @author march
 */
public class SnowBerries extends Modifier {
    public SnowBerries(Dish dish) {
        super(dish);
    }
    
    @Override
    public String getDescription() {
        return dish.getDescription() + " + снежные ягоды";
    }
    
    @Override
    public int getPrice() {
        return dish.getPrice() + 5;
    }  
}
