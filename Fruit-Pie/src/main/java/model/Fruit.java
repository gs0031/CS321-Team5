/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import model.units.Vector2D;

/**
 *  The fruit class defines the basic methods to be implemented in FruitBase,
 * that define fruit objects.
 * 
 * Provides methods to get and set the center coordinate of fruit objects and
 * their radius. These methods/logic are defined in the FruiBase Class.
 * 
 */
public interface Fruit {
    
    
    /*
    * @return vector of floating point x and y center of fruit
    */
    Vector2D getPosition();
    /*
    * @param x floating point coordinate of x to be registered
    * @param y floating point coordinate of y to be registered
    */
    void setPosition(float x, float y);
    /*
    * @return floating point radius of fruit
    */
    float getRadius();
    /*
    * @param radius floating point radius to be registered
    */
    void setRadius(float radius);
    
}
 
