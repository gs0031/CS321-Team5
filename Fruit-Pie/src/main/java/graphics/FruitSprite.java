/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

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