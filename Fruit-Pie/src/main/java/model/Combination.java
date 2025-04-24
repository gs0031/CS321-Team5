/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import java.util.LinkedList;

/**
 *  The class represents a list of a group of objects that are meant to be
 *  combined. The combination occurs to provide merging and eventually a 
 *  difference in score.
 * 
 * The class creates and maintains a list of fruits and provides a method
 * to add fruit to this list. Eventually should have other modifiers.
 * 
 */
public class Combination {
    /** A list that contains the fruit used for the combination */
    private List<Fruit> fruits;
    /** 
     * Constructor for Combination list, initializes empty list of fruits
     */
    public Combination() {
        this.fruits = new LinkedList<>();
 
    }
    /**
     * Adds fruit to the combination list for combination
     * @param fruit The fruit that is getting added to the combination
     */
    public void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }
}
