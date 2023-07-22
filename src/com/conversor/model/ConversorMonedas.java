package com.conversor.model;

import com.conversor.interfaces.ValorCambioMoneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorMonedas extends ConversorBase implements ActionListener, ValorCambioMoneda {
    static String[] currency = {
            "Peso Boliviano a Dólares",
            "Peso Boliviano a Euros",
            "Peso Boliviano a Libras Esterlinas",
            "Peso Boliviano a Yen Japonés",
            "Peso Boliviano a Won sur-coreano",
            "Dólares a Peso Boliviano",
            "Euros a Peso Boliviano",
            "Libras Esterlinas a Peso Boliviano",
            "Yen Japonés a Peso Boliviano",
            "Won sur-coreano a Peso Boliviano"
    };

    static ImageIcon icon = new ImageIcon("D:/Oracle ONE/Challenge/Challenge-2-Conversor/src/com/conversor/assets/icon1.png");

    public ConversorMonedas() throws HeadlessException {
        comboBox = new JComboBox<>(currency);
        comboBox.setFont(FONT);
        comboBox.addActionListener(this);

        button.addActionListener(this);
        backButton.addActionListener(this);

        informationLabel.setText("Ingrese el monto a convertir: ");

        topPanel.add(informationLabel);
        topPanel.add(TEXT_FIELD);

        midPanel.add(comboBox);
        midPanel.add(button);

        botPanel.add(conversionLabel1);

        backPanel.add(backButton);

        this.add(topPanel);
        this.add(midPanel);
        this.add(botPanel);
        this.add(backPanel);

        this.setTitle("Conversor de Monedas");
        this.setIconImage(icon.getImage());
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            selectionComboBox = comboBox.getSelectedIndex();
        }
        if (e.getSource() == button) {
            try {
                conversionLabel1.setText(convertir(TEXT_FIELD.getText(), selectionComboBox));
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

    @Override
    public String convertir(String monto, int option) {
        double valueConverted = Math.round(Double.parseDouble(monto) * ValorCambioMoneda.valorDeCambio[option] * 100.0) / 100.0;
        return "Resultado: " + valueConverted + " " + ValorCambioMoneda.monedaReferencia[option];
    }
}
