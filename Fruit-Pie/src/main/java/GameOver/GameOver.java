package GameOver;

import javax.swing.*;

public class GameOver {
    private boolean gameOverStatus;

    public GameOver() {
        this.gameOverStatus = false;
    }

    public boolean isGameOver() {
        return gameOverStatus;
    }

    public void setGameOver(boolean status) {
        this.gameOverStatus = status;
    }
}
