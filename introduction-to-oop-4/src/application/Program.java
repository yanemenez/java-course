package application;

import entities.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the dollar price: ");
        double dollarPrice = sc.nextDouble();
        System.out.print("How many dollar will be booght: ");
        double dollarsToBuy = sc.nextDouble();

        double amount = CurrencyConverter.amountInReais(dollarPrice, dollarsToBuy);
        System.out.print("Amount to be paid in reais: " + amount);

        sc.close();
    }
}