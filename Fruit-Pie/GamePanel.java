/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    //FPS
    int FPS = 60;
    
    KeyHandler keyH = new KeyHandler();
    Thread gameThread; // Keeps the program runing until you stop it
    
    //Set fruit's default position
    int fruitx = 450;
    int fruity = 100;
    int fruitSpeed = 4;
    
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
                
    }
    
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
       
    }

    @Override
    public void run() 
    {
        double drawInterval = 1000000000/FPS; // draws the screen 60 times per second
        double nextDrawTime = System.nanoTime() + drawInterval;
            
        while(gameThread != null) 
        {
            
            // 1. UPDATE: Update information such as fruit positions
            update();
            
            // 2. DRAW: draw the screen with the updated information
            repaint();
            
            
            try 
            {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                
                if(remainingTime < 0)
                {
                    remainingTime = 0;
                }
                
                Thread.sleep((long) remainingTime);
                
                nextDrawTime += drawInterval;
            } 
            
            catch (InterruptedException ex) 
            {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void update()
    {
        if(keyH.leftPressed == true)
        {
            fruitx -= fruitSpeed;
        }
        
        else if(keyH.rightPressed == true)
        {
            fruitx += fruitSpeed;
        }
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.white);
        
        g2.fillRect(fruitx, fruity, tileSize, tileSize);
        
        g2.dispose();
    }
}
