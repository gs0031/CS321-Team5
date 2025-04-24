package GameOver;

import javax.swing.*;

/**
 * A Class for setting and returning the game over status
 * 
 */
public class GameOver {

    private boolean gameOverStatus;

    /**
     * Sets the gameOverStatus to false when called
     */
    public GameOver() {
        this.gameOverStatus = false;
    }

    /**
     * States if gameOverStatus is true or false
     *
     * @return true/false value that states if the game is over
     */
    public boolean isGameOver() {
        return gameOverStatus;
    }

    /**
     * Creates a type boolean object that is used to store the gameOverStatus
     *
     * @param status the current status of the games state taken from
     * gameOverStatus
     */
    public void setGameOver(boolean status) {
        this.gameOverStatus = status;
    }
}

