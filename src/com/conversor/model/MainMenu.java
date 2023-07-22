package com.conversor.model;

import javax.swing.*;

public class MainMenu {
    String[] options = {"Conversor de Monedas", "Conversor de Temperatura", "Conversor de Distancias"};
    Object optionSelected;
    ImageIcon menuIcon = new ImageIcon("D:/Oracle ONE/Challenge/Challenge-2-Conversor/src/com/conversor/assets/menuIcon.png");

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
