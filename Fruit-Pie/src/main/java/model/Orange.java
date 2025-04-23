/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.image.BufferedImage;

/**
 * Orange Class is meant to be a subclass of another class in the model package.
 * Currently unfinished. Designed to handle the 'spawn' of oranges and their details
 * such as size, color, display, and tag.
 *
 */
public class Orange extends FruitBase {
    
    
    public Orange(float x, float y, float radius) {
        super(x, y, radius);
    }
    
    @Override
    public float getRadius() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setRadius(float radius) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
       

 
    
    /** Default constructor used only for javadoc generation */
    public Orange(){}

}
