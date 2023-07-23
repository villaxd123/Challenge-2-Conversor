package com.conversor.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ConversorTemperaturas adopts the basic attributes from {@link ConversorBase} and its configurations, at the same
 * time implementes {@link ActionListener}.
 * <p>The class has a static vector String for the options who will be used on the {@link JComboBox} and the {@link ImageIcon}
 * for the icon.</p>
 *
 * @author Jorge Villafuerte
 * @version 1.0
 */
public class ConversorTemperaturas extends ConversorBase implements ActionListener {
    static String[] OPTIONS = {
            "Grados Celsius",
            "Grados Fahrenheit",
            "Grados Kelvin"
    };

    static ImageIcon icon = new ImageIcon("D:/Oracle ONE/Challenge/Challenge-2-Conversor/src/com/conversor/assets/icon2.png");

    /**
     * The Constructor uses the {@link JComboBox} with the previous static attribute, after this it will set the font
     * of this (can't be set before because its null until is initialized).
     * <br>
     * The {@link ActionListener} is added to 3 elements: comboBox, button and backButton.
     * <br>
     * The comboBox event is with the purpose of save the index on an inherited attribute.
     * <br>
     * The button events are for performing an action that completes the purpose of the class.
     * <br>
     * Finally, adds the components to the frame and sets the title, the icon and the visibility.
     *
     * @throws HeadlessException like the parent class, it can throw this exception.
     */
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

    /**
     * <p>Parses the {@code amount} twice and stores the conversion based on the comboBox index.</p>
     * <p>The result of the conversion is rounded using the following formula:</p>
     * <pre>
     *     Math.round(x * 100.0) / 100.0
     * </pre>
     * <p>The objective is to obtain a double with 2 decimals.</p>
     * <p>The result rounded is stored in the {@code names[]} array.</p>
     *
     * @param amount is the String value from the TEXT_FIELD.
     * @param option is the index from the comboBox.
     * @return The index of the array names based on the option parameter.
     */
    private String convertir(String amount, int option) {
        double[] valueConverted = {0.0, 0.0};
        String[] names = {"", ""};
        if (selectionComboBox == 0) { // Celsius a Fahrenheit y Kelvin
            valueConverted[0] = Math.round(((Double.parseDouble(amount) * 9 / 5) + 32) * 100.0) / 100.0;
            valueConverted[1] = Math.round((Double.parseDouble(amount) + 273.15) * 100.0) / 100.0;
            names[0] = "Fahrenheits: " + valueConverted[0] + " ºF |";
            names[1] = "Kelvins: " + valueConverted[1] + " ºK";
        } else if (selectionComboBox == 1) { // Fahrenheit a Celsius y Kelvin
            valueConverted[0] = Math.round(((Double.parseDouble(amount) - 32) * 5 / 9) * 100.0) / 100.0;
            valueConverted[1] = Math.round((((Double.parseDouble(amount) - 32) * 5 / 9) + 273.15) * 100.0) / 100.0;
            names[0] = "Celsius: " + valueConverted[0] + " ºC |";
            names[1] = "Kelvins: " + valueConverted[1] + " ºK";
        } else if (selectionComboBox == 2) { // Kelvin a Celsius y Fahrenheit
            valueConverted[0] = Math.round((Double.parseDouble(amount) - 273.15) * 100.0) / 100.0;
            valueConverted[1] = Math.round((((Double.parseDouble(amount) -273.15) * 9 / 5) + 32) * 100.0) / 100.0;
            names[0] = "Celsius: " + valueConverted[0] + " ºC |";
            names[1] = "Fahrenheits: " + valueConverted[1] + " ºF";
        }
        return names[option];
    }

    /**
     * Override the actionPerformed from {@link ActionListener} and performs actions based on the source of the event
     * captured.
     * <p>The 1st source checked is the comboBox, this will store its index on a variable and call the convertir()
     * method sending 2 parameters.</p>
     * <p>The 2nd source checked is the button, this will call the convertir() method sending 2 parameters.</p>
     * <p>The last source checked is the backButton, this will dispose the actual frame and will create a new MainMenu.</p>
     * <br>
     * <p>The 1st and 2nd sources checked are surrounded with a <em>try-catch</em> expecting to catch
     * a {@link NumberFormatException}, if the exception is detected both will call a parent method.</p>
     *
     * @param e the event to be checked with the if statements.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            selectionComboBox = comboBox.getSelectedIndex();
            try {
                conversionLabel1.setText(convertir(TEXT_FIELD.getText(), 0));
                conversionLabel2.setText(convertir(TEXT_FIELD.getText(), 1));
            } catch (NumberFormatException exception) {
                super.messageError();
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
}
