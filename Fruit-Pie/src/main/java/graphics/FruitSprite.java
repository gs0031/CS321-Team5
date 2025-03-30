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
    private BufferedImage fruitImage;
    
    public FruitSprite(String resourcePath) {
        loadResource(resourcePath);
    }
    private void loadResource(String path) { 
        try {
            fruitImage = ImageIO.read(FruitSprite.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g, Vector2D position) {
        super.paintComponent(g);
        g.drawImage(fruitImage, (int)position.x, (int)position.y, this);
        
    }
}
