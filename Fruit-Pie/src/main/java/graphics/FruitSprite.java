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
 *
 * @author Scheherazade
 */
public class FruitSprite extends JComponent {
    static private BufferedImage fruitImage;
    
    public FruitSprite(String resourcePath) {
        loadResource(resourcePath);
    }
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
    public void draw(Graphics2D g, Vector2D position, int radius) {
        super.paintComponent(g);
        g.drawImage(fruitImage, (int)position.x, (int)position.y, radius, radius, this);
        
    }
}
