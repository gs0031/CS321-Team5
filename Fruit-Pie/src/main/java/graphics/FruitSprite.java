/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


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
        
        
public class FruitSprite {
    private final String name;
    private final Image image;

    public FruitSprite(String name, Image image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void draw(GraphicsContext gc, int x, int y, int size) {
        gc.drawImage(image, x, y, size, size);

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FruitSprite)) return false;
        FruitSprite other = (FruitSprite) obj;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}