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

/**
 * GamePanel class manages the rendering, game loop, and game logic 
 * for FruitPie's game play. The class handles keyboard and mouse inputs,
 * renders the game scene through JavaFX, and continually updates the game
 * state based on dropped fruits, collisions, and score.
 * 
 */

public class GamePanel extends StackPane implements Runnable 
{
    /** Static high score variable, tracks highest score from all sessions */
    public static int highScore = 0; 
    /** The main drawing/scene canvas/area */
    private final Canvas canvas = new Canvas(960, 768);
    /** Graphics context for rendering game visuals */
    private final GraphicsContext gc = canvas.getGraphicsContext2D();
    /** number of grid columns */
    final int maxScreenCol = 20; 
    /** number of grid rows*/
    final int maxScreenRow = 16;  
    /** Scenes target Frames per second */
    int FPS = 60;

    /** Handles user keyboard inputs */
    InputHandler keyH = new InputHandler();
    /** main game thread */
    Thread gameThread;

    /** Starting x position of the fruit (middle of the screen) */
    float fruitXRatio = 0.5f; 
    /** Starting Y position for the fruit (top of the screen) */
    float fruitYRatio = 0.15f;
    
    /** ask about later */
    private boolean validHi;
    
    /** True when game over condition is reached. */
    boolean gameOver = false;
    /** Track the current score */
    int score = 0; 

    /** UI container for game over buttons */
    private VBox buttonBox;
    /** reference to the current active scene */
    private Scene scene;

    /** Track if the fruit is in the dropping/falling state */
    private boolean isDropping = false; 
    /** Speed of the fruit when dropping */
    private double dropSpeed = 0.02; 

    /** List to track all dropped fruits positions */
    private List<Float[]> droppedFruits = new ArrayList<>();
    /** List to track dropped fruits colors */
    private List<Color> droppedFruitColors = new ArrayList<>();

    
    /** Color of the current falling fruit */
    private Color currentFruitColor = getRandomFruitColor();
    /** Color of the fruit being collided with */
    private Color collidingFruitColor;

    /** Track the number of collisions occurred */
    private int collisionCount = 0; 


    /**
     * Constructs the new game panel
     * Sets up input listeners for keyboard and mouse and starts game
     * thread/loop.
     * @param scene ff
     */
    public GamePanel(Scene scene) 
    {
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

   
    /**
     * Handle mouse click event to trigger the fruit drop slowly
     * @param event Mouse Click Event from input system
     */
    private void handleMouseClick(MouseEvent event) 
    {
        if (!isDropping && fruitYRatio < 0.78f) 
        {
            isDropping = true;  // Start the drop
        }
    }

    // Start game thread
    /**
     * Starts the gam loop on new thread
     */
    public void startGameThread() 
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Main game loop that handles timing, updating and handling
     */
    @Override
    public void run() 
    {
        double drawInterval = 1000000000.0 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) 
        {
            if (gameOver) 
            {
                Platform.runLater(this::renderGameOverScreen);
                return;
            }

            update();
            Platform.runLater(this::render);

            try 
            {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000.0;
                if (remainingTime < 0) remainingTime = 0;
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } 
            
            catch (InterruptedException ex) 
            {
                ex.printStackTrace();
            }
        }
    }


    /**
     * Deals with the Game Logic
     * Updates the game state, including fruit movements, collisions, 
     * and score tracking.
     */
    public void update() 
    {
        if (keyH.escPressed) 
        {
            gameOver = true;
        }
        
        //New Collision hitboxes
        if (isDropping && fruitYRatio < 0.88f) 
        {
            int collidingIndex = -1;
            fruitYRatio += dropSpeed; // Move the fruit down slowly
            
            // Check for collisions with dropped fruits
            boolean collisionDetected = false;
            double radiusRatio = 0.5;
            
            for (Float[] fruit : droppedFruits) 
            {

                for (int i = 0; i < droppedFruits.size(); i++) 
                {
                
                    double dx = fruit[0] - fruitXRatio;
                    double dy = fruit[1] - fruitYRatio;

                    double distance = Math.sqrt(dx * dx + dy * dy);

                    if (distance < radiusRatio * 0.15) 
                    {
                        collidingIndex = i;
                        collisionDetected = true;
                        isDropping = false;

                        break;

                    }
                }
            }
            /*--------------------------------------------------------------------
        
            
            -------------------------------------------------------------------
            */
            
            if ( fruitYRatio <= 0.25f)
            {
                validHi = true;
            }
        
            if (collisionDetected) 
            {
                collidingFruitColor = droppedFruitColors.get(collidingIndex);

                System.out.println("Collision detected!");
                System.out.println("Current Fruit Color: " + currentFruitColor.toString());
                System.out.println("Colliding Fruit Color: " + collidingFruitColor.toString());
                
                collisionCount++;  // Increment the collision count
                
                /*-------------------------------------------------------------------
                //Merging Logic
                if (currentFruitColor.equals(collidingFruitColor))
                {
                    // Remove the old fruit
                    droppedFruits.remove(collidingIndex);
                    droppedFruitColors.remove(collidingIndex);

                    // Create a new merged fruit at the collision location
                    droppedFruits.add(new Float[] { fruitXRatio, fruitYRatio });

                    // You could use a brighter or special color for merged fruit (or upgrade logic)
                    Color mergedColor = Color.PURPLE;  // Placeholder
                    droppedFruitColors.add(mergedColor);

                    score += 20; // Bonus for merging
                    checkHighScore();
                    spawnNewFruit();
                    return;  // Exit update to skip default drop handling
                }
                -----------------------------------------------------------------------
                */

                if (collisionCount >= 100 || (validHi && fruitYRatio <= 0.2f)) 
                {
                    gameOver = true;  // End the game after 5 collisions
                    return;
                }

                // If collision is detected, add the fruit to the list and spawn a new fruit
                isDropping = false;  // End the drop
                droppedFruits.add(new Float[] { fruitXRatio, fruitYRatio });
                droppedFruitColors.add(currentFruitColor);  // Add the consistent color of the current fruit
                score += 10;  // Increment score by 10
                validHi = false;
                checkHighScore();  // Check if a new high score is reached
                spawnNewFruit();  // Reset position of the next falling fruit                
            }
            
            else if (fruitYRatio >= 0.88f) 
            {
                // If no collision and the fruit reaches the bottom border, stop it
                fruitYRatio = 0.88f;  // Stop the drop at the bottom border
                droppedFruits.add(new Float[] { fruitXRatio, fruitYRatio });
                droppedFruitColors.add(currentFruitColor);  // Add the color of the new fruit
                score += 10;  // Increment score by 10
                validHi = false;
                checkHighScore();  // Check if a new high score is reached
                spawnNewFruit();  // Spawn a new fruit
                isDropping = false;  // End the drop
            }
                
        }
        
        /*--------------------------------------------------------------------
        Original Working Collision Hitboxes
        // If fruit is in dropping state, gradually move it down
        if (isDropping && fruitYRatio < 0.88f) 
        {
            fruitYRatio += dropSpeed; // Move the fruit down slowly

            // Check for collisions with dropped fruits
            boolean collisionDetected = false;

            // Check for collisions with previously dropped fruits
           
            for (Float[] fruit : droppedFruits) 
            {
                if (Math.abs(fruit[0] - fruitXRatio) < 0.1 && 
                    Math.abs(fruit[1] - fruitYRatio) < 0.1) 
                {
                    
                    
                        collisionDetected = true;
                        
                        isDropping = false; 
                        
                        break;
                }
            }
            
            if ( fruitYRatio <= 0.25f)
            {
                validHi = true;
            }

            if (collisionDetected) 
            {
                collisionCount++;  // Increment the collision count

                if (collisionCount >= 100 || (validHi && fruitYRatio <= 0.2f)) 
                {
                    gameOver = true;  // End the game after 5 collisions
                    return;
                }

                // If collision is detected, add the fruit to the list and spawn a new fruit
                isDropping = false;  // End the drop
                droppedFruits.add(new Float[] { fruitXRatio, fruitYRatio });
                droppedFruitColors.add(currentFruitColor);  // Add the consistent color of the current fruit
                score += 10;  // Increment score by 10
                checkHighScore();  // Check if a new high score is reached
                spawnNewFruit();  // Reset position of the next falling fruit                
            } 
            
            else if (fruitYRatio >= 0.88f) 
            {
                // If no collision and the fruit reaches the bottom border, stop it
                fruitYRatio = 0.88f;  // Stop the drop at the bottom border
                droppedFruits.add(new Float[] { fruitXRatio, fruitYRatio });
                droppedFruitColors.add(currentFruitColor);  // Add the color of the new fruit
                score += 10;  // Increment score by 10
                checkHighScore();  // Check if a new high score is reached
                spawnNewFruit();  // Spawn a new fruit
                isDropping = false;  // End the drop
            }
        }
        //-------------------------------------------------------
        */
        
        // Control movement if the fruit is not currently dropping
        
            // Control movement if the fruit is not currently dropping
       
            if(!isDropping)
            {
                if (fruitYRatio < 0.88f) 
                {
                    if (fruitXRatio > 0.1f && keyH.leftPressed) 
                    {
                        fruitXRatio -= 0.01f;  // Move left
                    }
                    if (fruitXRatio < 0.90f && keyH.rightPressed) 
                    {
                        fruitXRatio += 0.01f;  // Move right
                    }
                    if (keyH.dropPressed) 
                    {
                        fruitYRatio += 0.05f;  // Make the fruit fall faster
                    }
                }
            }
    }

    
    /**
     * Checks if the current score is a new high score
     * If is, updates the static highs core
     */
    private void checkHighScore() 
    {
        if (score > highScore) 
        {
            highScore = score;  // Update the static high score
        }
    }

    
    /**
     * Spawn a new fruit after the previous one has dropped
     * Spawns with new random color a resets to starting position.
     */
    private void spawnNewFruit() 
    {
        // Set the color for the current fruit (randomly set at the beginning)
        currentFruitColor = getRandomFruitColor(); // Assign color to current fruit if it's the first fruit

        // Reset the fruit position
        fruitXRatio = 0.5f; // Middle of the screen
        fruitYRatio = 0.15f; // Top of the screen
    }

    
    /**
     * Renders game visuals such as the background, dropped fruits, and current
     * fruit
     * Draws circles to represent current and already falling/fallen fruit.
     */
    public void render() 
    {
        int width = (int) canvas.getWidth();
        int height = (int) canvas.getHeight();
        int tileSize = Math.min(width / maxScreenCol, height / maxScreenRow);

        gc.setFill(Color.PEACHPUFF);
        gc.fillRect(0, 0, width, height);

        // Render all dropped fruits as circles with their stored colors
        for (int i = 0; i < droppedFruits.size(); i++) 
        {
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

    
    /**
     * Renders the game over screen with score display and menu buttons
     * Buttons exit application or return to main menu screen.
     * Renders last game frame.
     */
    public void renderGameOverScreen() 
    {
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
                } 
                
                catch (Exception ex) 
                {
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

    
    /**
     * Styled Menu button creation method
     * @param text Text that is displayed on the button
     * @return Styled Menu Button, JavaFX
     */
    private Button createMenuButton(String text) 
    {
        Button btn = new Button(text);
        btn.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 18));
        btn.setStyle("-fx-background-color: LIGHTYELLOW; -fx-text-fill: darkred; -fx-background-radius: 15;");
        btn.setPrefWidth(220);
        btn.setOnMouseEntered(e -> btn.setScaleX(1.1));
        btn.setOnMouseExited(e -> btn.setScaleX(1.0));
        return btn;
    }

    /**
     * Generates and returns random fruit color to be assigned to newly spawning
     * fruit.
     * @return random selected color object representing fruit
     */
    private Color getRandomFruitColor() 
    {
        int randomFruit = (int) (Math.random() * 3);  // Randomly pick a fruit type

        switch (randomFruit) 
        {
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
