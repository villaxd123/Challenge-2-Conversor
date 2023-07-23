package com.conversor.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ConversorMonedas adopts the basic attributes from
 * {@link ConversorBase} and modifies the final size of the window while,
 * at the same time implementes {@link ActionListener}.
 * <p>The class has a static vector String for the options who will be used on the {@link JComboBox} and the {@link ImageIcon}
 * for the icon.</p>
 *
 * @author Jorge Villafuerte
 * @version 1.0
 */
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

    static ImageIcon icon = new ImageIcon("D:/Oracle ONE/Challenge/Challenge-2-Conversor/src/com/conversor/assets/icon3.png");

    /**
     * The Constructor uses the {@link JComboBox} with the previous static attribute, after this it will set the font
     * of this (can't be set before because its null until is initialized).
     * <p>The {@link ActionListener} is added to 3 elements: comboBox, button and backButton.</p>
     * <p>The comboBox event is with the purpose of save the index on an inherited attribute.</p>
     * <p>The buttons events are for perform an action that complete the purpose of the class.</p>
     * <p>Finally, adds the components to the frame and sets the tittle, the icon and the visibility. </p>
     * <br>
     *
     * @throws HeadlessException like the parent class, it can throw this exception.
     */
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
        this.setIconImage(icon.getImage());
        this.setVisible(true);
    }

    /**
     * <p>Parses the {@code monto} in a double, then creates a double[] array and 2 Strings.</p>
     * <p>After the initialize of the variables the method uses an enhanced <em>switch-case</em> statement for the conversion.
     * The array has 8 vales because there are just 8 types of distances, the first 4 values will be used on the 1st String
     * abd the next 4 values for the 2nd String.</p>
     * <p>The conversion is made based on the {@code option} parameter who has stored the index of the comboBox.</p>
     * <p>When the conversion is done, the values are rounded using the following formula:</p>
     * <pre>
     *     Math.round(x * 100.0) / 100.0
     * </pre>
     * <p>The objective is to get a double with 2 decimals.</p>
     * <p>Finally, the result is added to the String using html to make line-breaks using HTML and the 2 labels calls to
     * setText to use the new result and show in the final interface.</p>
     *
     * @param text is the String value from the TEXT_FIELD.
     * @param option is the index from the comboBox.
     */
    private void convertir(String text, int option) {
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

    /**
     * Override the actionPerformed from {@link ActionListener} and performs actions based on the source of the event
     * captured.
     * <p>The 1st source checked is the comboBox, this will store its index on a variable.</p>
     * <p>The 2nd source checked is the button, this will call the convertir() method sending 2 parameters. This is
     * surrounded with a <em>try-catch</em> expecting to catch a {@link NumberFormatException}, if the exception is
     * detected will call a parent method.</p>
     * <p>The last source checked is the backButton, this will dispose the actual frame and will create a new MainMenu.</p>
     *
     * @param e the event to be checked with the if statements.
     */
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
