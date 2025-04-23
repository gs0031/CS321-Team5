/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *  The fruit class defines the basic methods to be implemented in FruitBase,
 * that define fruit objects.
 * 
 * Provides methods to get and set the center coordinate of fruit objects and
 * their radius. These methods/logic are defined in the FruiBase Class.
 * 
 */
public interface Fruit {
    
    
    /**
     * Returns/Gets the x coordinate of the fruits center
     * @return x-coordinate of fruit center
     */
    int getX();
    /**
     * Returns/gets the y coordinate of the fruits center
     * @return y-coordinate of fruit center
     */
    int getY();
    /**
     * Sets the x coordinate of the fruits center
     * @param x new x-coordinate of fruit center
     */
    void setX(int x);
    /**
     * Sets the y coordinate of the fruits center
     * @param y new y-coordinate of fruit center
     */
    void setY(int y);
    /**
     * Returns/Gets the radius of the fruit object
     * @return radius of the fruit object
     */
    int getRadius();
    /**
     * Sets the radius of the fruit object
     * @param radius new radius of fruit object
     */
    void setRadius(int radius);
    
}
