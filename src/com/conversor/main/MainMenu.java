package com.conversor.main;

import com.conversor.monedas.ConversorMonedas;

import javax.swing.*;

public class MainMenu {
    String[] options = {"Conversor de Monedas", "Conversor de Temperatura", "Conversor de Unidades"};
    Object optionSelected;
    ImageIcon menuIcon = new ImageIcon("src/com/conversor/assets/menuIcon.png");

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
            System.out.println(2);
        } else if (optionSelected == "Conversor de Unidades") {
            System.out.println(3);
        }
    }
}
