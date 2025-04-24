/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.units.Vector2D;
import java.awt.image.BufferedImage;


/**
 * Abstract class for all fruit types.
 * Creates default implementation for position related methods using 
 * the common properties provided such as a vector position and radius
 * 
 */
public abstract class FruitBase implements Fruit {
    /** fruits position in a 2D plane/space */
    protected Vector2D position;
    /** radius of the fruit, used for rendering */
    protected float radius;
    /** image representation of fruits */
    protected static BufferedImage image;
    
    /**
     * Constructor of abstract fruit type with specified position and radius
     * @param x the x-coordinate of the fruit
     * @param y the y-coordinate of the fruit
     * @param radius the radius of the fruit
     */
    public FruitBase(float x, float y, float radius) {
 
        this.position = new Vector2D(x, y);
        this.radius = radius;
        
    }
    /**
     * Returns fruits current position
     * @return a vector representing the fruits position
     */
    @Override
    public Vector2D getPosition() {
        return position;
    }
    /**
     * Sets the fruits position to the specified coordinates 
     * @param x new fruit x-coordinate
     * @param y new fruit y-coordinate 
     */
    @Override
    public void setPosition(float x, float y) {
        this.position.x = x;
        this.position.y = y;
    }
    
}