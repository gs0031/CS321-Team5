package graphics;

import fruitpie.InputHandler;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import fruitpie.mainmenu.FruitPieMainMenu;

import java.util.ArrayList;
import java.util.List;

public class GamePanel extends StackPane implements Runnable {

    public static int highScore = 0;  // Static high score variable

    private final Canvas canvas = new Canvas(960, 768);
    private final GraphicsContext gc = canvas.getGraphicsContext2D();

    final int maxScreenCol = 20;  // Grid columns
    final int maxScreenRow = 16;  // Grid rows
    int FPS = 60;

    InputHandler keyH = new InputHandler();
    Thread gameThread;

    float fruitXRatio = 0.5f; // Starting position of the fruit (middle of the screen)
    float fruitYRatio = 0.15f; // Starting Y position for the fruit (top of the screen)

    boolean gameOver = false;
    int score = 0;  // Track the current score

    private VBox buttonBox;
    private Scene scene;

    private boolean isDropping = false; // Track if the fruit is in the dropping state
    private double dropSpeed = 0.02; // Speed of the drop

    private List<Float[]> droppedFruits = new ArrayList<>(); // List to track all dropped fruits
    private List<Color> droppedFruitColors = new ArrayList<>(); // List to track fruit colors

    // Current fruit color
    private Color currentFruitColor = getRandomFruitColor();

    private int collisionCount = 0; // Track the number of collisions

    // Constructor
    public GamePanel(Scene scene) {
        this.scene = scene;
        setPrefSize(960, 768);

        this.getChildren().add(canvas);

        // Keyboard input
        setFocusTraversable(true);
        this.addEventHandler(KeyEvent.KEY_PRESSED, keyH);
        this.addEventHandler(KeyEvent.KEY_RELEASED, keyH);

        // Mouse input for dropping the fruit
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, this::handleMouseClick);

        startGameThread();
    }

    // Handle mouse click event to start the drop slowly
    private void handleMouseClick(MouseEvent event) {
        if (!isDropping && fruitYRatio < 0.78f) {
            isDropping = true;  // Start the drop
        }
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

    // Game Logic
    public void update() {
        if (keyH.escPressed) {
            gameOver = true;
        }

        if (isDropping) {
    fruitXRatio += fruitXVelocity;
    fruitYRatio += dropSpeed;

    float radiusRatio = 0.5f / maxScreenCol; // half a tile
    boolean collisionDetected = false;

    for (int i = 0; i < droppedFruits.size(); i++) {
        Float[] fruit = droppedFruits.get(i);
        float dx = fruit[0] - fruitXRatio;
        float dy = fruit[1] - fruitYRatio;
        float distance = (float) Math.sqrt(dx * dx + dy * dy);

        if (distance < radiusRatio * 2) {
            // Collision detected: Snap on top
            fruitYRatio = fruit[1] - radiusRatio * 2;
            settleFruit();
            collisionDetected = true;
            break;
        }
    }

    // No collision, but reached bottom
    if (!collisionDetected && fruitYRatio >= 0.88f) {
        fruitYRatio = 0.88f;
        settleFruit();
    }
}

        // Control movement if the fruit is not currently dropping
        if (fruitYRatio < 0.88f) {
            if (fruitXRatio > 0.1f && keyH.leftPressed) {
                fruitXRatio -= 0.01f;  // Move left
            }
            if (fruitXRatio < 0.90f && keyH.rightPressed) {
                fruitXRatio += 0.01f;  // Move right
            }
            if (keyH.dropPressed) {
                fruitYRatio += 0.05f;  // Make the fruit fall faster
            }
        }
    }

    private void settleFruit() {
    droppedFruits.add(new Float[] { fruitXRatio, fruitYRatio });
    droppedFruitColors.add(currentFruitColor);
    score += 10;
    checkHighScore();
    spawnNewFruit();
    isDropping = false;
}

    // Check if the current score is a new high score
    private void checkHighScore() {
        if (score > highScore) {
            highScore = score;  // Update the static high score
        }
    }

    // Spawn a new fruit after the previous one has dropped
    private void spawnNewFruit() {
        // Set the color for the current fruit (randomly set at the beginning)
        currentFruitColor = getRandomFruitColor(); // Assign color to current fruit if it's the first fruit

        // Reset the fruit position
        fruitXRatio = 0.5f; // Middle of the screen
        fruitYRatio = 0.15f; // Top of the screen
    }

    // Render game visuals
    public void render() {
        int width = (int) canvas.getWidth();
        int height = (int) canvas.getHeight();
        int tileSize = Math.min(width / maxScreenCol, height / maxScreenRow);

        gc.setFill(Color.PEACHPUFF);
        gc.fillRect(0, 0, width, height);

        // Render all dropped fruits as circles with their stored colors
        for (int i = 0; i < droppedFruits.size(); i++) {
            Float[] fruit = droppedFruits.get(i);
            int fruitX = (int) (fruit[0] * width);
            int fruitY = (int) (fruit[1] * height);
            int radius = tileSize / 2; // Radius of the fruit (half the tile size)

            Color fruitColor = droppedFruitColors.get(i); // Get color from the list

            // Draw a circle to represent a fruit
            gc.setFill(fruitColor);
            gc.fillOval(fruitX - radius, fruitY - radius, radius * 2, radius * 2);
        }

        // Render the current dropping fruit
        int currentFruitX = (int) (fruitXRatio * width);
        int currentFruitY = (int) (fruitYRatio * height);
        int currentRadius = tileSize / 2; // Radius of the fruit

        // Draw the current falling fruit
        gc.setFill(currentFruitColor);
        gc.fillOval(currentFruitX - currentRadius, currentFruitY - currentRadius, currentRadius * 2, currentRadius * 2);

        int borderThickness = Math.max(tileSize / 5, 5);
        gc.setFill(Color.BLACK);
        gc.fillRect(tileSize, tileSize * 2, borderThickness, height - tileSize * 3);
        gc.fillRect(width - tileSize - borderThickness, tileSize * 2, borderThickness, height - tileSize * 3);
        gc.fillRect(tileSize, height - tileSize, width - tileSize * 2, borderThickness);

        // Display score
        gc.setFill(Color.DARKGREEN);
        gc.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 18));
        gc.fillText("Score: " + score, 20, 40);
    }

    // Game Over UI
    public void renderGameOverScreen() {
        render(); // Draw last game frame

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

    // Menu button creation method
    private Button createMenuButton(String text) {
        Button btn = new Button(text);
        btn.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 18));
        btn.setStyle("-fx-background-color: LIGHTYELLOW; -fx-text-fill: darkred; -fx-background-radius: 15;");
        btn.setPrefWidth(220);
        btn.setOnMouseEntered(e -> btn.setScaleX(1.1));
        btn.setOnMouseExited(e -> btn.setScaleX(1.0));
        return btn;
    }

    // This method returns a random color representing a fruit
    private Color getRandomFruitColor() {
        int randomFruit = (int) (Math.random() * 3);  // Randomly pick a fruit type

        switch (randomFruit) {
            case 0:
                return Color.rgb(255, 100, 100);  // Apple-like (Red)
            case 1:
                return Color.hsb(30, 0.7, 1.0);  // Orange-like (Orange)
            case 2:
                return Color.rgb(150, 255, 150);  // Green (Lime)
            default:
                return Color.BLUE; // Default to blue
        }
    }
}
