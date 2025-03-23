/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Scheherazade
 */
public class Combination {
    private List<Fruit> fruits;
    /** 
     * Constructor for Combination list, initializes empty list of fruits
     */
    public Combination() {
        this.fruits = new LinkedList<>();

    }
    public void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }
}
