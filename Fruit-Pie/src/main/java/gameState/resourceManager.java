/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameState;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *  Class provides methods for loading/saving serialized data to and from files.
 *  Class utilizes java object serialization.
 *  Class is used to create game state persistence among objects and scores.
 * 
 */
public class resourceManager {
    
    /** Default constructor used only for javadoc generation */
    public resourceManager(){}

    /**
     * Saves serialized objects to desired file.
     * @param data serialized data that is to be saved.
     * @param fileName name/path of file that information should be saved to.
     * @throws Exception if I/O error occurs during any saving
     */
    public static void save(Serializable data, String fileName) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            oos.writeObject(data);
        }
    }

    /**
     * loads de-serialized objects from desired file
     * @param fileName name/path of file that information should be loaded from.
     * @return de-serialized object from file.
     * @throws Exception if I/O error occurs during any loading or file cannot be found
     */
    public static Object load(String fileName) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return ois.readObject();
        }
    }
}
