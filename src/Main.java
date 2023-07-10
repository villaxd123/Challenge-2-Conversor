import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String[] options = {"Conversor de Monedas", "Conversor de Temperatura", "Conversor de Unidades"};

        Object optionSelected = JOptionPane.showInputDialog(
                null,
                "Escoja una opción",
                "Conversor",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );
        if (optionSelected == "Conversor de Monedas") {
            ConversorMonedas conversorMonedas = new ConversorMonedas();
        } else if (optionSelected == "Conversor de Temperatura") {
            System.out.println(2);
        } else if (optionSelected == "Conversor de Unidades") {
            System.out.println(3);
        }
    }
}
