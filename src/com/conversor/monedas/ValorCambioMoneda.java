package com.conversor.monedas;

public interface ValorCambioMoneda {
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
    String[] monedaReferencia = {
            "$",
            "€",
            "£",
            "¥",
            "₩",
            "Bs", "Bs", "Bs", "Bs", "Bs"
    };

    String convertir(String monto, int option);
}
