package fruitpie;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * The InputHandler class is responsible for handling keyboard inputs for our
 * game(FruitPie). The class tracks the state of specific keyboard events that
 * allows for movement, dropping, or ending the game. Updates boolean values
 * when pressed or released allowing other classes to utilize their input state.
 * Handled Keys: 
 *  A - Move Object Left 
 *  D - Move Object Right 
 *  M - Drop Object
 *  Escape - Prompts the end game screen
 *
 * 
 */
public class InputHandler implements EventHandler<KeyEvent> {
    
    /** Default constructor used only for javadoc generation */
    public InputHandler(){}

    /**
     * True if the A(left) key is currently pressed
     */
    public boolean leftPressed;
    /**
     * True if the D(right) key is currently pressed
     */
    public boolean rightPressed;
    /**
     * True if the M(drop) key is currently pressed
     */
    public boolean dropPressed;
    /**
     * True if the escape(esc) key is currently pressed
     */
    public boolean escPressed;

    /**
     * Handles the key event and updates values leftPressed, rightPressed,
     * dropPressed, escPressed accordingly.
     *
     * @param e The key event triggered by the user
     */
    @Override
    public void handle(KeyEvent e) {
        if (e.getEventType() == KeyEvent.KEY_PRESSED) {
            KeyCode code = e.getCode();

            if (code == KeyCode.A) {
                leftPressed = true;
            }

            if (code == KeyCode.D) {
                rightPressed = true;
            }

            if (code == KeyCode.M) {
                dropPressed = true;
            }

            // Handle the Esc key
            if (code == KeyCode.ESCAPE) {
                escPressed = true;
            }
        }

        if (e.getEventType() == KeyEvent.KEY_RELEASED) {
            KeyCode code = e.getCode();

            if (code == KeyCode.A) {
                leftPressed = false;
            }

            if (code == KeyCode.D) {
                rightPressed = false;
            }

            if (code == KeyCode.M) {
                dropPressed = false;
            }

            // Handle the Esc key
            if (code == KeyCode.ESCAPE) {
                escPressed = false;
            }
        }
    }
}
