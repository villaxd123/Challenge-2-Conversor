package com.conversor.model;

import javax.swing.*;
import java.awt.*;

/**
 * ConversorBase has all the components required to create a new Java Swing interface.
 *
 * @author Jorge Villafuerte
 * @version 1.0
 */
public class ConversorBase extends JFrame {
    /**
     * Consolas Font type Plain and size 15.
     */
    protected static Font FONT = new Font("Consolas", Font.PLAIN, 15);
    /**
     * Variable that stores the index of a comboBox.
     */
    protected int selectionComboBox = 0;
    /**
     * The 1st label that shows the user what is needed.
     */
    protected JLabel informationLabel = new JLabel();
    /**
     * The 1st label that shows the result of the conversion.
     */
    protected JLabel conversionLabel1 = new JLabel();
    /**
     * The 2nd label that shows the result of the conversion, only used if two rows are as an output.
     */
    protected JLabel conversionLabel2 = new JLabel();
    /**
     * The Box where the input is placed.
     */
    protected static JTextField TEXT_FIELD = new JTextField("0", 20);
    /**
     * Declaration of the comboBox without the initialization.
     */
    protected JComboBox<String> comboBox;
    /**
     * Button that performs the actions for the conversion.
     */
    protected JButton button = new JButton("Convertir");
    /**
     * Button that performs the action to return to the dialog interface.
     */
    protected JButton backButton = new JButton("Regresar");
    /**
     * {@link JPanel} who group the informationLabel and TEXT_FIELD.
     */
    protected JPanel topPanel = new JPanel();
    /**
     * {@link JPanel} who group the comboBox and the 1st button.
     */
    protected JPanel midPanel = new JPanel();
    /**
     * {@link JPanel} who group both conversionLabel. If the 2nd label isn't needed, it will not be added.
     */
    protected JPanel botPanel = new JPanel();
    /**
     * This {@link JPanel} has the backButton.
     */
    protected JPanel backPanel = new JPanel();

    /**
     * The constructor starts initializing its own {@link JFrame} setting the DefaultCloseOperation, size of the window,
     * if it can be resizable, the main Layout as a Grid, then initialize the attributes with the same font and
     * a FlowLayout for every JPanel that it has, for the buttons the focusability is set on false and the location
     * relative is set to null to perform the position where the window will apear.
     *
     * @throws HeadlessException will be thrown only when the following code is called on an environment that depends
     * on a keyboard, display or mouse doesn't have it.
     * @see    #setDefaultCloseOperation
     * @see    java.awt.Window#processWindowEvent
     */
    public ConversorBase() throws HeadlessException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(525, 200);
        this.setResizable(false);
        this.setLayout(new GridLayout(4, 1));
        this.setLocationRelativeTo(null);

        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        midPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        botPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        backPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        informationLabel.setFont(FONT);
        conversionLabel1.setFont(FONT);
        conversionLabel2.setFont(FONT);

        TEXT_FIELD.setFont(FONT);

        button.setFont(FONT);
        button.setFocusable(false);

        backButton.setFont(FONT);
        backButton.setFocusable(false);
    }

    /**
     * Public method called for show a simple error message on a {@link JLabel}.
     */
    public void messageError() {
        conversionLabel1.setText("Sólo números decimales (separados por punto).");
        conversionLabel2.setText("");
    }
}
