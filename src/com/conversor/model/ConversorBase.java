package com.conversor.model;

import javax.swing.*;
import java.awt.*;

public class ConversorBase extends JFrame {
    protected static Font FONT = new Font("Consolas", Font.PLAIN, 15);
    protected int selectionComboBox = 0;
    protected JLabel informationLabel = new JLabel();
    protected JLabel conversionLabel1 = new JLabel();
    protected JLabel conversionLabel2 = new JLabel();
    protected static JTextField TEXT_FIELD = new JTextField("0", 20);
    protected JComboBox<String> comboBox;
    protected JButton button = new JButton("Convertir");
    protected JButton backButton = new JButton("Regresar");
    protected JPanel topPanel = new JPanel();
    protected JPanel midPanel = new JPanel();
    protected JPanel botPanel = new JPanel();
    protected JPanel backPanel = new JPanel();

    public ConversorBase() throws HeadlessException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(525, 200);
        this.setResizable(false);
        this.setLayout(new GridLayout(4, 1));

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

    public void messageError() {
        conversionLabel1.setText("Sólo números decimales (separados por punto).");
        conversionLabel2.setText("");
    }
}
