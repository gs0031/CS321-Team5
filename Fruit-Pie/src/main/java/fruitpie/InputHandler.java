package fruitpie;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InputHandler implements EventHandler<KeyEvent> {

    public boolean leftPressed, rightPressed, dropPressed, escPressed;

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
