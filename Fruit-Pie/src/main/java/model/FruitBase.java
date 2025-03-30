/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.units.Vector2D;
import java.awt.image.BufferedImage;


/**
 * 
 * @author Scheherazade
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
    @Override
    public Vector2D getPosition() {
        return position;
    }
    @Override
    public void setPosition(float x, float y) {
        this.position.x = x;
        this.position.y = y;
    }
    
}
