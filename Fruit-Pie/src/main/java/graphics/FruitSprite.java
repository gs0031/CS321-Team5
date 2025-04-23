/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;
import javafx.scene.canvas.GraphicsContext;
import java.awt.image.BufferedImage;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.JComponent;
import model.units.Vector2D;
import javafx.embed.swing.SwingFXUtils;


/**
 *
 * @author Scheherazade
 */
public class FruitSprite extends JComponent {
    private BufferedImage fruitBufferedImage;
    private Image fruitImage;
    
    public FruitSprite(String resourcePath) {
//        this.resourcePath = resourcePath;
        loadResource(resourcePath);
    }
    private void loadResource(String path) { 
        try {
            try (InputStream input = FruitSprite.class.getClassLoader().getResourceAsStream(path)) {
                if( input != null ) {
                    fruitBufferedImage = ImageIO.read(input);
                } else {
                    System.err.println("Resource not found");
                }
                fruitImage = SwingFXUtils.toFXImage(fruitBufferedImage, null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Registers parameters which are used to draw a bufferedimage onto the canvas
     * @param gc graphics context parameter
     * @param position Vector2D pos to draw the image on
     * @param radius radius
     */
    public void draw(GraphicsContext gc, float x, float y, int radius) {
        if(fruitImage != null) {
            gc.drawImage(fruitImage, x, y, radius, radius);
        
        }
    }
}

