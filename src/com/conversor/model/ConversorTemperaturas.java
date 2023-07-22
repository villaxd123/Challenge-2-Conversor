package com.conversor.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorTemperaturas extends ConversorBase implements ActionListener {
    static String[] OPTIONS = {
            "Grados Celsius",
            "Grados Fahrenheit",
            "Grados Kelvin"
    };

    static ImageIcon icon = new ImageIcon("src/com/conversor/assets/icon2.png");

    public ConversorTemperaturas() throws HeadlessException {
        comboBox = new JComboBox<>(OPTIONS);
        comboBox.setFont(FONT);
        comboBox.addActionListener(this);

        button.addActionListener(this);

        backButton.addActionListener(this);

        informationLabel.setText("Ingrese los grados a convertir: ");
        conversionLabel1.setText("El resultado se mostrará aquí.");

        topPanel.add(informationLabel);
        topPanel.add(TEXT_FIELD);

        midPanel.add(comboBox);
        midPanel.add(button);

        botPanel.add(conversionLabel1);
        botPanel.add(conversionLabel2);

        backPanel.add(backButton);

        this.add(topPanel);
        this.add(midPanel);
        this.add(botPanel);
        this.add(backPanel);

        this.setTitle("Conversor de Temperaturas");
        this.setIconImage(icon.getImage());
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            selectionComboBox = comboBox.getSelectedIndex();
            try {
                conversionLabel1.setText(convertir(TEXT_FIELD.getText(), 0));
                conversionLabel2.setText(convertir(TEXT_FIELD.getText(), 1));
            } catch (NumberFormatException exception) {
                messageError();
            }
        }
        if (e.getSource() == button) {
            try {
                conversionLabel1.setText(convertir(TEXT_FIELD.getText(), 0));
                conversionLabel2.setText(convertir(TEXT_FIELD.getText(), 1));
            } catch (NumberFormatException exception) {
                super.messageError();
            }
        }
        if (e.getSource() == backButton) {
            this.dispose();
            MainMenu mainMenu = new MainMenu();
            mainMenu.openOptionSelected();
        }
    }

    private String convertir(String amount, int option) {
        double[] valueConverted = {0.0, 0.0};
        String[] names = {"", ""};
        if (selectionComboBox == 0) { // Celsius a Fahrenheit y Kelvin
            valueConverted[0] = (double) Math.round(((Double.parseDouble(amount) * 9 / 5) + 32) * 100) / 100;
            valueConverted[1] = (double) Math.round((Double.parseDouble(amount) + 273.15) * 100) / 100;
            names[0] = "Fahrenheits: " + valueConverted[0] + " ºF |";
            names[1] = "Kelvins: " + valueConverted[1] + " ºK";
        } else if (selectionComboBox == 1) { // Fahrenheit a Celsius y Kelvin
            valueConverted[0] = (double) Math.round(((Double.parseDouble(amount) - 32) * 5 / 9) * 100) / 100;
            valueConverted[1] = (double) Math.round((((Double.parseDouble(amount) - 32) * 5 / 9) + 273.15) * 100) / 100;
            names[0] = "Celsius: " + valueConverted[0] + " ºC |";
            names[1] = "Kelvins: " + valueConverted[1] + " ºK";
        } else if (selectionComboBox == 2) { // Kelvin a Celsius y Fahrenheit
            valueConverted[0] = (double) Math.round((Double.parseDouble(amount) - 273.15) * 100) / 100;
            valueConverted[1] = (double) Math.round((((Double.parseDouble(amount) -273.15) * 9 / 5) + 32) * 100) / 100;
            names[0] = "Celsius: " + valueConverted[0] + " ºC |";
            names[1] = "Fahrenheits: " + valueConverted[1] + " ºF";
        }
        return names[option];
    }
}
