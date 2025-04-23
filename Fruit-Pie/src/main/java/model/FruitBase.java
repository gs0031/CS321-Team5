/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.units.Vector2D;
import java.awt.image.BufferedImage;


/**
 * FruitBase class provides a basic implementation of the Fruit model.
 * It is used to define the common properties shared by fruit objects such as
 * the size/radius of the object and the position of the fruit object.
 * 
 * This class sets and retrieves the x, y coordinates of the fruits center 
 * and radius of the fruit.
 * 
 *  Will be extended by other fruit classes such as orange, etc.
 * 
 */
public abstract class FruitBase implements Fruit {
    protected Vector2D position;
    protected float radius;
    protected static BufferedImage image;
    
    /**
     * Constructor of abstract fruit type
     * @param x
     * @param y
     * @param radius
     */
    public FruitBase(float x, float y, float radius) {
 
        this.position = new Vector2D(x, y);
        this.radius = radius;
        
    }
    /**
     * Returns/Gets the x coordinate of the fruits center
     * @return the x coordinate
     */
    @Override
    public int getX() {
        return x;
    }
    /**
     * Returns/Gets the y coordinate of the fruits center
     * @return the y coordinate 
     */
    @Override
    public Vector2D getPosition() {
        return position;
    }
    /**
     * Sets the x coordinate of the fruits center
     * @param x the new x coordinate of the fruit
     */
    @Override
    public void setPosition(float x, float y) {
        this.position.x = x;
        this.position.y = y;
    }

    
}
