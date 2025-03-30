package graphics;

import fruitpie.InputHandler;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import fruitpie.mainmenu.FruitPieMainMenu;

public class GamePanel extends StackPane implements Runnable {

    private final Canvas canvas = new Canvas(960, 768);
    private final GraphicsContext gc = canvas.getGraphicsContext2D();

    final int maxScreenCol = 20;
    final int maxScreenRow = 16;
    int FPS = 120;

    InputHandler keyH = new InputHandler();
    Thread gameThread;

    float fruitXRatio = 0.5f;
    float fruitYRatio = 0.15f;

    boolean gameOver = false;
    int highScore = 0;

    private VBox buttonBox;
    private Scene scene;

    // Constructor
    public GamePanel(Scene scene) {
        this.scene = scene;
        setPrefSize(960, 768);

        this.getChildren().add(canvas);

        // Keyboard input
        setFocusTraversable(true);
        this.addEventHandler(KeyEvent.KEY_PRESSED, keyH);
        this.addEventHandler(KeyEvent.KEY_RELEASED, keyH);

        startGameThread();
    }

    // Start game thread
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            if (gameOver) {
                Platform.runLater(this::renderGameOverScreen);
                return;
            }

            update();
            Platform.runLater(this::render);

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000.0;
                if (remainingTime < 0) remainingTime = 0;
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Update game logic
    public void update() {
        if (keyH.escPressed) {
            gameOver = true;
        }

        if (fruitYRatio < 0.78f) {
            if (fruitXRatio > 0.1f && keyH.leftPressed) {
                fruitXRatio -= 0.01f;
            }
            if (fruitXRatio < 0.85f && keyH.rightPressed) {
                fruitXRatio += 0.01f;
            }
            if (keyH.dropPressed) {
                fruitYRatio += 0.05f;
            }
        }
    }

    // Render game visuals
    public void render() {
        int width = (int) canvas.getWidth();
        int height = (int) canvas.getHeight();
        int tileSize = Math.min(width / maxScreenCol, height / maxScreenRow);

        gc.setFill(Color.PEACHPUFF);
        gc.fillRect(0, 0, width, height);

        int fruitX = (int) (fruitXRatio * width);
        int fruitY = (int) (fruitYRatio * height);
        gc.setFill(Color.WHITE);
        gc.fillRect(fruitX, fruitY, tileSize, tileSize);

        int borderThickness = Math.max(tileSize / 5, 5);
        gc.setFill(Color.BLACK);
        gc.fillRect(tileSize, tileSize * 2, borderThickness, height - tileSize * 3);
        gc.fillRect(width - tileSize - borderThickness, tileSize * 2, borderThickness, height - tileSize * 3);
        gc.fillRect(tileSize, height - tileSize, width - tileSize * 2, borderThickness);
    }

    // Game Over UI
    public void renderGameOverScreen() {
        render(); // Draw last game frame

        if (buttonBox != null) this.getChildren().remove(buttonBox);

        gc.setFill(Color.DARKORANGE);
        gc.setFont(Font.font("Comic Sans MS", 48));
        gc.fillText("Game Over!", 320, 200);

        gc.setFill(Color.DARKGREEN);
        gc.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 18));
        gc.fillText("🏆 High Score: " + highScore, 360, 300);

        // Buttons
        Button mainMenuButton = createMenuButton("Main Menu");
        Button exitBtn = createMenuButton("🚪 Exit");

        mainMenuButton.setOnAction(e -> {
            // Launch FruitPieMainMenu when the button is clicked
            Platform.runLater(() -> {
                try {
                    // Start the main menu (FruitPieMainMenu)
                    new FruitPieMainMenu().start(new Stage());
                    // Close the current game window (this Stage)
                    ((Stage) mainMenuButton.getScene().getWindow()).close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        });

        exitBtn.setOnAction(e -> Platform.exit());

        VBox menuBox = new VBox(15, mainMenuButton, exitBtn);
        menuBox.setAlignment(Pos.CENTER);

        VBox centerBox = new VBox(30, menuBox);
        centerBox.setAlignment(Pos.CENTER);

        // Add the menu to the current StackPane (this)
        this.getChildren().add(centerBox);
    }


    // Placeholder for main menu return
    private void goToMainMenu() {
        // Replace this with your actual main menu navigation logic
        System.out.println("Going back to main menu...");
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    private Button createMenuButton(String text) {
        Button btn = new Button(text);
        btn.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 18));
        btn.setStyle("-fx-background-color: LIGHTYELLOW; -fx-text-fill: darkred; -fx-background-radius: 15;");
        btn.setPrefWidth(220);
        btn.setOnMouseEntered(e -> btn.setScaleX(1.1));
        btn.setOnMouseExited(e -> btn.setScaleX(1.0));
        return btn;
    }
}
