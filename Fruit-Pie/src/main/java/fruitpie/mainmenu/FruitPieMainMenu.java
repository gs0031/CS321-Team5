package fruitpie.mainmenu;

import graphics.GamePanel;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FruitPieMainMenu extends Application {
    private boolean soundOn = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
public void start(Stage primaryStage) {
    // Gradient Background
    Stop[] stops = new Stop[]{
        new Stop(0, Color.PEACHPUFF),
        new Stop(1, Color.LIGHTYELLOW)
    };
    LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
    Background background = new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY));

    BorderPane root = new BorderPane();
    root.setBackground(background);

    // Title
    Label title = new Label("🍓 Fruit Pie 🍊");
    title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 48));
    title.setTextFill(Color.DARKORANGE);
    title.setEffect(new DropShadow(10, Color.ORANGE));

    // High Score Display (still optional; keep or remove)
    Label highScoreLabel = new Label("🏆 High Score: 0");
    highScoreLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
    highScoreLabel.setTextFill(Color.DARKGREEN);
    highScoreLabel.setTranslateX(50);
    highScoreLabel.setTranslateY(50);

    // Buttons
    Button startBtn = createMenuButton("▶ Start Game");
    Button instrBtn = createMenuButton("📝 Instructions");
    Button soundBtn = createMenuButton("🔊 Sound: OFF");
    Button exitBtn = createMenuButton("🚪 Exit");

    instrBtn.setOnAction(e -> {
        Alert instructions = new Alert(Alert.AlertType.INFORMATION);
        instructions.setTitle("How to Play");
        instructions.setHeaderText("Fruit Pie - Instructions");
        instructions.setContentText("🍓 How to Play: \n▶ TBD.");
        instructions.showAndWait();
    });

    soundBtn.setOnAction(e -> {
        soundOn = !soundOn;
        soundBtn.setText(soundOn ? "🔊 Sound: ON" : "🔇 Sound: OFF");
    });

    exitBtn.setOnAction(e -> primaryStage.close());

    startBtn.setOnAction(e -> {
        // Launch JavaFX GamePanel
        GamePanel gamePanel = new GamePanel(primaryStage.getScene());  // Pass the scene to GamePanel
        Scene gameScene = new Scene(new StackPane(gamePanel));
        primaryStage.setScene(gameScene);
        primaryStage.setTitle("Fruit Pie - Game");
        primaryStage.show();
    });

    VBox menuBox = new VBox(15, startBtn, instrBtn, soundBtn, exitBtn);
    menuBox.setAlignment(Pos.CENTER);

    VBox centerBox = new VBox(30, title, menuBox);
    centerBox.setAlignment(Pos.CENTER);

    // Use StackPane to position elements
    StackPane stack = new StackPane();
    stack.getChildren().addAll(centerBox, highScoreLabel); // Ensure highScoreLabel is on top
    StackPane.setAlignment(highScoreLabel, Pos.TOP_LEFT);

    root.setCenter(stack); // Set StackPane as center

    Scene scene = new Scene(root, 800, 600);
    primaryStage.setTitle("Fruit Pie - Main Menu");
    primaryStage.setScene(scene);
    primaryStage.show();
}


    private Button createMenuButton(String text) {
        Button btn = new Button(text);
        btn.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 18));
        btn.setStyle("-fx-background-color: peachpuff; -fx-text-fill: darkred; -fx-background-radius: 15;");
        btn.setPrefWidth(220);
        btn.setOnMouseEntered(e -> btn.setScaleX(1.1));
        btn.setOnMouseExited(e -> btn.setScaleX(1.0));
        return btn;
    }
}
