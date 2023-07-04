package com.poly.util;

import java.text.NumberFormat;
import java.util.Locale;

public class CustomNumberFormat {
    public static String formatCurrency(double value) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        return currencyFormat.format(value);
    }
}
