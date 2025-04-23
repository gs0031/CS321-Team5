/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
    /** x-coordinate of the center of the fruit */
    protected int x;
    /** y-coordinate of the center of the fruit */
    protected int y;
    /** radius of the fruit */
    protected int radius; 
    /**
     * Constructor - constructs Object of class FruitBase with specified 
     * position and radius
     * @param x x-coordinate of center
     * @param y y-coordinate of center
     * @param radius radius of fruit
     */
    public FruitBase(int x, int y, int radius) {
        this.x = x;
        this.y = y;
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
    public int getY() {
        return y;
    }
    /**
     * Sets the x coordinate of the fruits center
     * @param x the new x coordinate of the fruit
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }
    /**
     * Sets the y coordinate of the fruits center
     * @param y the new y coordinate of the fruit
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }
    /**
     * Returns/Gets the radius of the fruit
     * @return the current radius
     */
    @Override
    public int getRadius(){
        return radius;
    }
    /**
     * Sets the radius of the fruit
     * @param radius the new radius 
     */
    @Override
    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    
}
