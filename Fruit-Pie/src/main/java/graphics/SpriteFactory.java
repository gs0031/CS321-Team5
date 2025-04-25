/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import java.util.Map;
import java.util.HashMap;
import javafx.scene.image.Image;

/**
 * Handles some basic instantiation of graphics objects
 * Creates and stores reusable FruitSprite instances for different fruit types.
 * 
 */
public class SpriteFactory {
    /** Initialization of map where the name is key and FruitSprite objects are values */
    private Map<String, FruitSprite> sprites;
    
    /**
     * Constructs SpriteFactory and initializes new sprites map.
     * Sprites loaded from predefined resource and stored in the map.
     * 
     */
    public SpriteFactory() {
        sprites = new HashMap<>();
        initSprites();
    }
    
    /**
     * Initializes sprites of predefined fruit types.
     * FruitSprite objects are created with an image that is loaded from the 
     * image folder. 
     * As an initialization function, the function is only called once.
     */
    private void initSprites() {
        sprites.put("orange", new FruitSprite("orange", new Image(getClass().getResourceAsStream("/sprites/orange.png"))));
        sprites.put("strawberry", new FruitSprite("strawberry", new Image(getClass().getResourceAsStream("/sprites/strawberry.png"))));
        sprites.put("banana", new FruitSprite("banana", new Image(getClass().getResourceAsStream("/sprites/banana.png"))));
        sprites.put("watermelon", new FruitSprite("watermelon", new Image(getClass().getResourceAsStream("/sprites/watermelon.png"))));
        sprites.put("apple", new FruitSprite("apple", new Image(getClass().getResourceAsStream("/sprites/apple.png"))));
    }
    
    /**
     * Returns/retrieves a FruitSprite object by its name.
     * Returns null if object doesn't exist.
     * @param name the name of the fruit
     * @return the corresponding fruit to the name. 
     */
    public FruitSprite getSprite(String name) {
        return sprites.get(name);
    }
    
}
