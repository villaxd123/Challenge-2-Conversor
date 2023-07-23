package com.conversor.model;

import javax.swing.*;

/**
 * MainMenu is the class in charge to display the {@link JOptionPane} dialog to start the selection for every
 * type of the conversor (Monedas, Temperatura y Distancias).
 * <p>This class has 3 attributes, 2 statics an 1 object:</p>
 * <p>The 1st static is an array that stores the 3 options mentioned previously.</p>
 * <p>The 2nd static is the {@link ImageIcon} who stores the corresponding icon.</p>
 * <p>The Object will store the output of the dialog.</p>
 *
 * @author Jorge Villafuerte
 * @version 1.0
 */
public class MainMenu {
    static String[] options = {"Conversor de Monedas", "Conversor de Temperatura", "Conversor de Distancias"};
    static ImageIcon menuIcon = new ImageIcon("D:/Oracle ONE/Challenge/Challenge-2-Conversor/src/com/conversor/assets/menuIcon.png");
    Object optionSelected;

    /**
     * The constructor stores the output of the dialog inside the variable optionSelected.
     * This dialog has a message, a tittle, an icon,
     * 3 options (the 1st option is selected by default) and 2 action buttons (OK, Cancel).
     */
    public MainMenu() {
        optionSelected = JOptionPane.showInputDialog(
                null,
                "Escoja una opción:",
                "Conversor",
                JOptionPane.INFORMATION_MESSAGE,
                menuIcon,
                options,
                options[0]
        );
    }

    /**
     * This method is called when an option is selected from the dialog.
     * When is called checks the option selected and creates an anonymous {@link ConversorMonedas},
     * {@link ConversorTemperaturas} or {@link ConversorDistancias},
     * these three are extended from {@link ConversorBase}.
     */
    public void openOptionSelected() {
        if (optionSelected == "Conversor de Monedas") {
            new ConversorMonedas();
        } else if (optionSelected == "Conversor de Temperatura") {
            new ConversorTemperaturas();
        } else if (optionSelected == "Conversor de Distancias") {
            new ConversorDistancias();
        }
    }
}
