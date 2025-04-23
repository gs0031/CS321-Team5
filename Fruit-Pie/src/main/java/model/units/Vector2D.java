/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.units;

/**
 * 2D vector encapsulation for simplifying position operations on fruit
 * @author Scheherazade
 */
public class Vector2D {
    /** specifies x coordinate in floating point format */
    public float x;
    /** specifies y coordinate in floating point format */
    public float y;
    
    /**
     *  Class constructor specifying the respective x and y coordinates in floating point format.
     * @param x specifies x coordinate in floating point format of object
     * @param y specifies y coordinate in floating point format of object
     */
    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
