package fruitpie;

import fruitpie.mainmenu.FruitPieMainMenu;
import javafx.application.Application;

/**
 * This class, FruitPie, serves as the entry point for the javafx application
 * found in FruitPieMainMenu. The class contains the method (main) that launches
 * the beginning of the game.
 *
 */
public class FruitPie {
    
    /**
     * Default constructor used only for javadoc generation
     */
    public FruitPie(){}
    /**
     * The main method that launches the main menu display/ the javafx
     * application found in FruitPieMainMenu. Essentially used to launch the
     * application.
     *
     * @param args passes command line arguments to javafx application
     */
    public static void main(String[] args) {
        Application.launch(FruitPieMainMenu.class, args);
    }
}
