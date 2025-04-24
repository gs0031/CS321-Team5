/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Represents drawable instance of the sprite of a fruit, contains name and 
 * image identifiers. 
 * Allows drawing of the sprite at a specified location with specified size,
 * name, and image.
 * Contains a method to check for similar fruit instances.
 * 
 */
public class FruitSprite {
    /** Name identifier of fruit objects */
    private final String name;
    /** Image associated with fruit objects */
    private final Image image;
    
    /**
     * Constructs new FruitSprite with specified name and image
     * @param name the name of the fruit
     * @param image the image representing the fruit object
     */
    public FruitSprite(String name, Image image) {
        this.name = name;
        this.image = image;
    }
    
    /**
     * Returns the name associated with the fruit sprite
     * @return name of fruit 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Draws the fruit sprite image at a specified location and specified size
     * given the graphics context to draw.
     * @param gc the graphics context to draw the image
     * @param x the x-coordinate to be drawn to from canvas
     * @param y the y-coordinate to be drawn to from canvas
     * @param size width/height to draw the image (presumably a square)
     */
    public void draw(GraphicsContext gc, int x, int y, int size) {
        gc.drawImage(image, x, y, size, size);
    }
    
    /**
     * Check if this FruitSprite is equal to another instance of the class
     * Comparison is done through name identifiers.
     * @param obj the object that this object is being compared to
     * @return true if the other object is a FruitSprite of the same name, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FruitSprite)) return false;
        FruitSprite other = (FruitSprite) obj;
        return this.name.equals(other.name);
    }
    
    /**
     * Returns Hash Code for the FruitSprite based on its name
     * @return hash Code of the name of the FruitSprite
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}