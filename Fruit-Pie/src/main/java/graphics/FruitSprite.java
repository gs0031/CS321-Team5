/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.JComponent;
import model.units.Vector2D;


/**
 * Graphics component that represents our fruit sprite that is to be drawn on 
 * screen
 * Class handles loading the image source of the fruit and drawing it at a
 * specified location with a specified radius/size.
 * @author Scheherazade
 */
public class FruitSprite extends JComponent {
    /** Image representing the fruit sprite */
    static private BufferedImage fruitImage;
    /** 
     * Constructs the sprite and loads the sprites image from
     * the given resource path.
     * @param resourcePath path to the images resource/source.
     */
    public FruitSprite(String resourcePath) {
        loadResource(resourcePath);
    }
    /**
     * Loads the fruit image resource from the specified path
     * @param path path to the source of the image
     */
    public void loadResource(String path) { 
        try {
            try (InputStream input = FruitSprite.class.getClassLoader().getResourceAsStream(path)) {
                if( input != null ) {
                    fruitImage = ImageIO.read(input);
                } else {
//                    System.err.println("Resource not found");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Draws fruit image onto screen at a given position and radius
     * @param g graphics kit context for drawing the image
     * @param position position x and y on screen where image is to be drawn.
     * @param radius  width and height of drawn image.
     */
    public void draw(Graphics2D g, Vector2D position, int radius) {
        super.paintComponent(g);
        g.drawImage(fruitImage, (int)position.x, (int)position.y, radius, radius, this);
        
    }
}
