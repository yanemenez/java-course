package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or Company (i/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine(); 
            String name = sc.nextLine();
            System.out.print("Anual Income: ");
            double anualIncome = sc.nextDouble();

            if (ch == 'i' || ch == 'I') {
                System.out.print("Health Expenditures: ");
                double healthExpenditures = sc.nextDouble();
                Individual individual = new Individual(name, anualIncome, healthExpenditures);
                list.add(individual);
            } else {
                System.out.print("Number of Employees: ");
                int numberOfEmployees = sc.nextInt();
                Company company = new Company(name, anualIncome, numberOfEmployees);
                list.add(company);
            }
        }

        double sum = 0.0;
        System.out.println();
        System.out.println("TAXES PAID:");
        for (TaxPayer tp : list) {
            double tax = tp.tax();
            System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
            sum += tax;
        }
        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

        sc.close();
    }
}
