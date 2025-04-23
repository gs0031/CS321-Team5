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
 * @author Scheherazade
 */
public class SpriteFactory {
    private Map<String, FruitSprite> sprites;
    
    public SpriteFactory() {
        sprites = new HashMap<>();
        initSprites();
    }
    
    private void initSprites() {
        sprites.put("orange", new FruitSprite("orange", new Image(getClass().getResourceAsStream("/sprites/orange.png"))));
        sprites.put("strawberry", new FruitSprite("strawberry", new Image(getClass().getResourceAsStream("/sprites/Strawberry.png"))));
        sprites.put("banana", new FruitSprite("banana", new Image(getClass().getResourceAsStream("/sprites/banana.png"))));
        sprites.put("watermelon", new FruitSprite("watermelon", new Image(getClass().getResourceAsStream("/sprites/watermelon.png"))));
        sprites.put("apple", new FruitSprite("apple", new Image(getClass().getResourceAsStream("/sprites/apple.png"))));
    }
    
    
    public FruitSprite getSprite(String name) {
        return sprites.get(name);
    }
    
}
