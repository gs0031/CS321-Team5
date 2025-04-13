package fruitpie;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


/**
 *
 * @author brian
 */
public class InputHandeler implements KeyListener, MouseMotionListener 
{
    public boolean leftPressed, rightPressed, dropPressed, validMouse;
    
    public float xMouse;

    public void mousePressed(MouseEvent e) 
    {
        System.out.println("0005");
        int code = e.getButton();
        
        if(MouseEvent.BUTTON1 == code)
        {
            dropPressed = true;
        }
    }
    
    public void mouseReleased(MouseEvent e) 
    {
        float code = e.getButton();
        
        if(code == MouseEvent.BUTTON1)
        {
            dropPressed = false;
        }
    }
    
    @Override
    public void mouseMoved(MouseEvent e) 
    {
        float code = e.getXOnScreen();
        validMouse = true;
        xMouse = code;
    }
 

    @Override
    public void mouseDragged(MouseEvent e) 
    {}

    @Override
    public void keyTyped(KeyEvent e) 
    {}

    @Override
    public void keyPressed(KeyEvent e) 
    {
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_A)
        {
            leftPressed = true;
        }
        
        if(code == KeyEvent.VK_D)
        {
            rightPressed = true;
        }
        
        if(code == KeyEvent.VK_M)
        {
            dropPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_A)
        {
            leftPressed = false;
        }
        
        if(code == KeyEvent.VK_D)
        {
            rightPressed = false;
        }
        
        if(code == KeyEvent.VK_M)
        {
            dropPressed = false;
        }
    } 
}
