package com.conversor.interfaces;

/**
 * This interface has two attributes, and both are arrays,
 * the 1st array stores all the values of currency change and the 2nd array stores all the symbols for the corresponding currency's
 *
 * @author Jorge Villafuerte
 * @version 1.0
 */
public interface ValorCambioMoneda {
    /**
     * This array stores the different values for the currency conversion.
     */
    double[] valorDeCambio = {
            0.14568375,
            0.1326892,
            0.11383094,
            20.644433,
            190.12289,
            6.8579975,
            7.5289907,
            8.7820297,
            0.048421795,
            0.0052568927
    };
    /**
     * This array stores the different symbols that will be attached to the result of the conversion.
     */
    String[] monedaReferencia = {
            "$",
            "€",
            "£",
            "¥",
            "₩",
            "Bs", "Bs", "Bs", "Bs", "Bs"
    };

    /**
     * This method expects to be implemented for the conversion of the currency using {@code monto} and {@code option}
     *
     * @param monto expects to be the string obtained from a {@link javax.swing.JTextField}.
     * @param option expects to be an index from the {@link javax.swing.JComboBox}.
     * @return A String with the text to be the output.
     */
    String convertir(String monto, int option);
}
