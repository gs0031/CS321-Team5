/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fruitpie;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author brian
 */
public class InputHandeler implements KeyListener
{
    
    public boolean leftPressed, rightPressed, dropPressed;


    // Not Needed ----------------------------------------------
    @Override
    public void keyTyped(KeyEvent e) 
    {}
    //----------------------------------------------------------

    
    //Allows for left and right movement------------------------
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
        
        if (code == KeyEvent.VK_M)
        {
            dropPressed = true;
            
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
        
        if (code == KeyEvent.VK_M)
        {
            dropPressed = false;
        }
        
    }
    
    

   
    
    
}
