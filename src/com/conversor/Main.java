package com.conversor;

import com.conversor.model.MainMenu;

/**
 * Main class with the main method that starts all the program.
 *
 * @author Jorge Villafuerte
 * @version 1.0
 */
public class Main {

    /**
     * This method creates a new instance of {@link MainMenu} and calls to openOptionSelected().
     *
     * @param args default parameter.
     */
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.openOptionSelected();
    }
}
