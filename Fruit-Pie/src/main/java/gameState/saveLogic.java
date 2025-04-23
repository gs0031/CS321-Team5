/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameState;

/**
 * Class represents variables that are to be saved from game state. Class
 * implements java.io.Serializable, allowing objects to be read and written from
 * data for persistance handling.
 *
 * Class used to store highscore, score, and each fruits x, y, radius, and color
 * valus
 *
 */
public class saveLogic implements java.io.Serializable {
    
    /** Default constructor used only for javadoc generation */
    public saveLogic(){}
    
   
    private static final long serialVersionUID = 1L;
    /**
     * High score saved from all-time game sessions
     */
    public int hScore;
    /**
     * Score from most recent game session
     */
    public int ssScore;
    /**
     * x coordinate of last or current fruit
     */
    public int x;
    /**
     * y coordinate of last or current fruit
     */
    public int y;
    /**
     * radius of last or current fruit
     */
    public int radius;
    /**
     * Color of last or current fruit.
     */
    public int color;

}
