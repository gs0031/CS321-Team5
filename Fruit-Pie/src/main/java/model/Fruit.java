/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author Scheherazade
 */
public interface Fruit {
    
    /**
     * 
     * @return x-coord of fruit center
     */
    int getX();
    /**
     * 
     * @return y-coord of fruit center
     */
    int getY();
    /**
     * 
     * @param x new x-coordinate 
     */
    void setX(int x);
    /**
     * 
     * @param y new y-coordinate
     */
    void setY(int y);
    /**
     * 
     * @return radius of the fruit body
     */
    int getRadius();
    /**
     * @param radius new radius
     */
    void setRadius(int radius);
    
}
