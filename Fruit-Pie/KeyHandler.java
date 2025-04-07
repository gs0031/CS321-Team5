package fruitpie;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class InputHandler implements EventHandler<KeyEvent>, MouseMotionListener  
{

    public boolean leftPressed, rightPressed, dropPressed, escPressed, validMouse;
    
    public float xMouse;
    
    
    
    @Override
    public void mouseMoved(MouseEvent e) 
    {
        float code = e.getXOnScreen();
        validMouse = true;
        xMouse = code;
        System.out.println("5005");
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
    public void mouseDragged(MouseEvent e) 
    {}
    
    
    
    @Override
    public void handle(KeyEvent e) 
    {
        if (e.getEventType() == KeyEvent.KEY_PRESSED) 
        {
            KeyCode code = e.getCode();

            if (code == KeyCode.A) 
            {
                leftPressed = true;
            }

            if (code == KeyCode.D) 
            {
                rightPressed = true;
            }

            if (code == KeyCode.M) 
            {
                dropPressed = true;
            }

            // Handle the Esc key
            if (code == KeyCode.ESCAPE) 
            {
                escPressed = true;
            }
        }

        if (e.getEventType() == KeyEvent.KEY_RELEASED) 
        {
            KeyCode code = e.getCode();

            if (code == KeyCode.A) 
            {
                leftPressed = false;
            }

            if (code == KeyCode.D) 
            {
                rightPressed = false;
            }

            if (code == KeyCode.M) 
            {
                dropPressed = false;
            }

            // Handle the Esc key
            if (code == KeyCode.ESCAPE) 
            {
                escPressed = false;
            }

        }
    }
    
}

    }
    
}
