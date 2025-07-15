package entities;

public class CurrencyConverter {
    public static final double IOF_RATE = 0.06;

    public static double amountInReais(double dollarPrice, double dollarsToBuy) {
        return dollarsToBuy * dollarPrice * (1 + IOF_RATE);
    }

}
