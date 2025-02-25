/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author brian
 */
public class GamePanel extends JPanel implements Runnable{
    // SCREEN SETINGS
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;
    
    final int tileSize = originalTileSize * scale; //16x3
    final int maxScreenCol = 20;
    final int maxScreenRow = 16;
    final int screenWidth = tileSize * maxScreenCol; // 760 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    
    Thread gameThread; // Keeps the program runing until you stop it
    
    
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.yellow);
        this.setDoubleBuffered(true);
                
    }
    
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
       
    }

    @Override
    public void run() 
    {
        while(gameThread != null) 
        {
            System.out.println("The game loop is running");
        }
    }
}
