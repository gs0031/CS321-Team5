# CS321-Team5
# Fruit Pie

Fruit Pie is a 2D JavaFX-based puzzle game where players stack and merge fruits to earn points. The objective is to combine matching fruits and achieve the highest score before the stack reaches the top.

## Features

- Merge fruits like apple, banana, strawberry, orange, and watermelon
- Gravity-based stacking system
- Score tracking for each fruit combination
- Game over menu with high score display
- JavaFX user interface with canvas-based rendering
- Responsive input handling and smooth game flow

## Project Structure

Fruit-Pie/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── fruitpie/           # Main launcher and menu logic
│   │   │   ├── graphics/           # GamePanel, SpriteFactory, and UI
│   │   │   └── model/              # Fruit and combination logic
│   │   └── resources/
│   │       └── sprites/            # Image files (apple.png, banana.png, etc.)
├── target/                         # Maven build output
├── pom.xml                         # Maven project configuration
└── README.md

## Getting Started
## Javadocs
When generating JavaDocs from the NetBeans IDE, they fail to automatically pop-up as intended
However the JavaDocs still generate in the folders. Below is the specified path once
in the projects file.

Path to JavaDocs | CS321-Team5 > Fruit-Pie > target > reports > apidocs > index.html

### Prerequisites

- Java 17 or later
- Maven 3.6 or newer
- JavaFX SDK (only required if not using Maven plugin)

### Run the Game
Ensure your JAVA_HOME is set to a valid JDK that supports JavaFX.

then run 

cd "CS321-Team5\Fruit-Pie\target"
java -jar Fruit-Pie-1.0.jar

or 

Open in NetBeans then click Play Button


## Troubleshooting



## Modular Info

This project uses Java modules. Make sure your `module-info.java` includes the required modules and opens packages:

```java
module fruitpie {
    requires javafx.controls;
    requires javafx.fxml;

    opens fruitpie to javafx.fxml;
    opens graphics to javafx.fxml;
}