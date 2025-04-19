/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author brian
 */
public class KeyHandler implements KeyListener {
    
    public boolean leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) 
    {
        // Not Needed ----------------------------------------
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_A)
        {
            leftPressed = true;
        }
        
        if (code == KeyEvent.VK_D)
        {
            rightPressed = true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_A)
        {
            leftPressed = false;
        }
        
        if (code == KeyEvent.VK_D)
        {
            rightPressed = false;
        }
        
    }
    
}
