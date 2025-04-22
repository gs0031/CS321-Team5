/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import java.util.Map;
import java.util.HashMap;

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
        
        sprites.put("orange", new FruitSprite("orange.png"));
//        sprites.put("strawberry", new FruitSprite("Strawberry.png"));
        sprites.put("banana", new FruitSprite("banana.png"));
        
    }
    
    
    public FruitSprite getSprite(String name) {
        return sprites.get(name);
    }
    
}
