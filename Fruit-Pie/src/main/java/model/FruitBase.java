/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * 
 * @author Scheherazade
 */
public abstract class FruitBase implements Fruit {
    protected int x; // x-coord of center
    protected int y; // y-coord of center
    protected int radius; // radius of fruit
    /**
     * Constructor
     * @param x x-coord of center
     * @param y y-coord of center
     * @param radius radius of fruit
     */
    public FruitBase(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    @Override
    public int getX() {
        return x;
    }
    @Override
    public int getY() {
        return y;
    }
    @Override
    public void setX(int x) {
        this.x = x;
    }
    @Override
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public int getRadius(){
        return radius;
    }
    @Override
    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    
}
