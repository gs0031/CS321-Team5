/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.image.BufferedImage;

/**
 * Represents the orange fruit object and inherits behavior and properties
 * from the FruitBase class.
 * 
 * Has get and set methods that are not currently implemented.
 * 
 */
public class Orange extends FruitBase {
    
    /**
     * Constructs new orange object with specified position and radius.
     * @param x x-coordinate of the orange
     * @param y y-coordinate of the orange
     * @param radius radius of the orange
     */
    public Orange(float x, float y, float radius) {
        super(x, y, radius);
    }
    
    /**
     * Gets the radius of the orange
     * @return the radius of the orange object
     */
    @Override
    public float getRadius() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * Sets the new radius for the orange
     * @param radius new radius for orange, to be set
     */
    @Override
    public void setRadius(float radius) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
       

 
    
}