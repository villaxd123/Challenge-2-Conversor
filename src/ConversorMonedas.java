import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorMonedas extends JFrame implements ActionListener, ValorCambioMoneda {
    String[] currency = {
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
    Font font = new Font("Consolas", Font.PLAIN, 15);
    int selectionComboBox = 0;
    JLabel informationLabel = new JLabel("Ingrese el monto a convertir.");
    JLabel conversionLabel = new JLabel();
    JTextField textField = new JTextField("0", 10);
    JComboBox<String> comboBox = new JComboBox<>(currency);
    JButton button = new JButton("Convertir");

    public ConversorMonedas() throws HeadlessException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setBounds(0, 0, 500, 500);

        informationLabel.setFont(font);
        conversionLabel.setFont(font);

        textField.setFont(font);

        comboBox.setFont(font);
        comboBox.addActionListener(this);

        button.setFont(font);
        button.setFocusable(false);
        button.addActionListener(this);

        this.add(informationLabel);
        this.add(textField);
        this.add(comboBox);
        this.add(button);
        this.add(conversionLabel);

        this.setTitle("Conversor de Monedas");
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            selectionComboBox = comboBox.getSelectedIndex();
        }
        if (e.getSource() == button) {
            try {
                conversionLabel.setText(convertir(textField.getText(), selectionComboBox));
            } catch (NumberFormatException exception){
                messageError("Por favor ingrese un monto numérico (se permiten decimales)");
            }
        }
    }

    @Override
    public String convertir(String monto, int option) {
        double valueConverted = Math.round(Double.parseDouble(monto) * valorDeCambio[option] * 100.0) / 100.0;
        return "Resultado: " + valueConverted + " " + monedaReferencia[option];
    }

    public void messageError(String s) {
        conversionLabel.setText(s);
    }
}
