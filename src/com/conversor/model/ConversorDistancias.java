package com.conversor.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorDistancias extends ConversorBase implements ActionListener {
    static String[] OPTIONS = {
            "Kilómetros",
            "Metros",
            "Centímetros",
            "Millas",
            "Yardas",
            "Pies",
            "Pulgadas",
            "Millas Náuticas"
    };

    public ConversorDistancias() throws HeadlessException {
        super.setSize(525, 350);

        comboBox = new JComboBox<>(OPTIONS);
        comboBox.setFont(FONT);
        comboBox.addActionListener(this);

        informationLabel.setText("Ingrese el valor a convertir: ");
        conversionLabel1.setText("El resultado se mostrará aquí.");

        button.addActionListener(this);
        backButton.addActionListener(this);

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

        this.setTitle("Conversor de Distancias");
        this.setVisible(true);
    }

    public void convertir(String text, int option) {
        double inputConverted = Double.parseDouble(text);
        double[] valuesConverted = {0, 0, 0, 0, 0, 0, 0, 0};

        String resultA = "<html><body>";
        String resultB = "<html><body>";

        switch (option) {
            case 0 -> { // kilómetros
                valuesConverted[0] = inputConverted;
                valuesConverted[1] = inputConverted * 1000;
                valuesConverted[2] = inputConverted * 100000;
                valuesConverted[3] = inputConverted / 1.609;
                valuesConverted[4] = inputConverted * 1094;
                valuesConverted[5] = inputConverted * 3281;
                valuesConverted[6] = inputConverted * 39370;
                valuesConverted[7] = inputConverted / 1.852;
            }
            case 1 -> { // metros
                valuesConverted[0] = inputConverted / 1000;
                valuesConverted[1] = inputConverted;
                valuesConverted[2] = inputConverted * 100;
                valuesConverted[3] = inputConverted / 1609;
                valuesConverted[4] = inputConverted * 1.094;
                valuesConverted[5] = inputConverted * 3.281;
                valuesConverted[6] = inputConverted * 39.37;
                valuesConverted[7] = inputConverted / 1852;
            }
            case 2 -> { // centímetros
                valuesConverted[0] = inputConverted / 100000;
                valuesConverted[1] = inputConverted / 100;
                valuesConverted[2] = inputConverted;
                valuesConverted[3] = inputConverted / 160900;
                valuesConverted[4] = inputConverted / 91.44;
                valuesConverted[5] = inputConverted / 30.48;
                valuesConverted[6] = inputConverted / 2.54;
                valuesConverted[7] = inputConverted / 185200;
            }
            case 3 -> { // millas
                valuesConverted[0] = inputConverted * 1.609;
                valuesConverted[1] = inputConverted * 1609;
                valuesConverted[2] = inputConverted * 160900;
                valuesConverted[3] = inputConverted;
                valuesConverted[4] = inputConverted * 1706;
                valuesConverted[5] = inputConverted * 5280;
                valuesConverted[6] = inputConverted * 63360;
                valuesConverted[7] = inputConverted / 1.151;
            }
            case 4 -> { // yardas
                valuesConverted[0] = inputConverted / 1094;
                valuesConverted[1] = inputConverted / 1.094;
                valuesConverted[2] = inputConverted * 91.44;
                valuesConverted[3] = inputConverted / 1760;
                valuesConverted[4] = inputConverted;
                valuesConverted[5] = inputConverted * 3;
                valuesConverted[6] = inputConverted * 36;
                valuesConverted[7] = inputConverted / 2025;
            }
            case 5 -> { // pies
                valuesConverted[0] = inputConverted / 3281;
                valuesConverted[1] = inputConverted / 3.281;
                valuesConverted[2] = inputConverted * 30.48;
                valuesConverted[3] = inputConverted / 5280;
                valuesConverted[4] = inputConverted / 3;
                valuesConverted[5] = inputConverted;
                valuesConverted[6] = inputConverted * 12;
                valuesConverted[7] = inputConverted / 6076;
            }
            case 6 -> { // pulgadas
                valuesConverted[0] = inputConverted / 39370;
                valuesConverted[1] = inputConverted / 39.37;
                valuesConverted[2] = inputConverted * 2.54;
                valuesConverted[3] = inputConverted / 63360;
                valuesConverted[4] = inputConverted / 30;
                valuesConverted[5] = inputConverted / 12;
                valuesConverted[6] = inputConverted;
                valuesConverted[7] = inputConverted / 72910;
            }
            case 7 -> { // millas náuticas
                valuesConverted[0] = inputConverted * 1.852;
                valuesConverted[1] = inputConverted * 1852;
                valuesConverted[2] = inputConverted * 185200;
                valuesConverted[3] = inputConverted * 1.151;
                valuesConverted[4] = inputConverted * 2025;
                valuesConverted[5] = inputConverted * 6076;
                valuesConverted[6] = inputConverted * 72910;
                valuesConverted[7] = inputConverted;
            }
            default -> {
            }
        }

        for (int i = 0; i < valuesConverted.length; i++) {
            valuesConverted[i] = Math.round(valuesConverted[i] * 100.0) / 100.0;
        }

        resultA += "Kilómetros: " + valuesConverted[0] + "km<br>";
        resultA += "Metros: " + valuesConverted[1] + "m<br>";
        resultA += "Centímetros: " + valuesConverted[2] + "cm<br>";
        resultA += "Millas: " + valuesConverted[3] + "mi<br>";
        resultB += "Yardas: " + valuesConverted[4] + "yd<br>";
        resultB += "Pies: " + valuesConverted[5] + "ft<br>";
        resultB += "Pulgadas: " + valuesConverted[6] + "in<br>";
        resultB += "Millas Náuticas: " + valuesConverted[7] + "mn<br>";
        resultA += "</body></html>";
        resultB += "</body></html>";

        conversionLabel1.setText(resultA);
        conversionLabel2.setText(resultB);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            selectionComboBox = comboBox.getSelectedIndex();
        }
        if (e.getSource() == button) {
            try {
                convertir(TEXT_FIELD.getText(), selectionComboBox);
            } catch (NumberFormatException exception){
                super.messageError();
            }
        }
        if (e.getSource() == backButton) {
            this.dispose();
            MainMenu mainMenu = new MainMenu();
            mainMenu.openOptionSelected();
        }
    }
}
