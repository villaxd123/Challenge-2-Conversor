package com.conversor.model;

import com.conversor.interfaces.ValorCambioMoneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ConversorMonedas adopts the basic attributes from {@link ConversorBase} and its configurations, at the same time
 * implements {@link ActionListener} and {@link ValorCambioMoneda}.
 * <p>The class has a static vector String for the options who will be used on the {@link JComboBox} and the {@link ImageIcon}
 * for the icon.</p>
 *
 * @author Jorge Villafuerte
 * @version 1.0
 */
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

    /**
     * Parses the {@code monto} in a double and multiplies with the corresponding value from the {@link ValorCambioMoneda}
     * then the result uses this formula:
     * <pre>
     *     Math.round(x * 100.0) / 100.0
     * </pre>
     * The purpose is to obtain a double with 2 decimals for a better view from the final interface.
     *
     * @param monto  is the String value from the TEXT_FIELD.
     * @param option is the index from the comboBox.
     * @return The String with the result and the symbol for the currency.
     */
    @Override
    public String convertir(String monto, int option) {
        double valueConverted = Math.round(Double.parseDouble(monto) * ValorCambioMoneda.valorDeCambio[option] * 100.0) / 100.0;
        return "Resultado: " + valueConverted + " " + ValorCambioMoneda.monedaReferencia[option];
    }

    /**
     * Override the actionPerformed from {@link ActionListener} and performs actions based on the source of the event
     * captured.
     * <p>The 1st source checked is the comboBox, this will store its index on a variable.</p>
     * <p>The 2nd source checked is the button, this will call the convertir() method sending 2 parameters. This is
     * surrounded with a <em>try-catch</em> expecting to catch a {@link NumberFormatException}, if the exception is
     * detected will call a parent method.</p>
     * <p>The last source checked is the backButton, this will dispose the actual frame and will create a new MainMenu.</p>
     *
     * @param e the event to be checked in the if statements.
     */
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
}
