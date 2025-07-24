package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many people will be entered: ");
        int n = sc.nextInt();

        String[] name_vect = new String[n];
        int[] age_vect = new int[n];
        double[] height_vect = new double[n];

        // Limpar o buffer do scanner
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter data for person #" + (i + 1) + ":");

            System.out.print("Name: ");
            name_vect[i] = sc.nextLine();

            System.out.print("Age: ");
            age_vect[i] = sc.nextInt();

            System.out.print("Height: ");
            height_vect[i] = sc.nextDouble();

            sc.nextLine();
        }

        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += height_vect[i];
        }

        double avg = sum / n;

        System.out.printf("AVERAGE HEIGHT: %.2f%n", avg);

        int countUnder16 = 0;

        for (int i = 0; i < n; i++) {
            if (age_vect[i] < 16) {
                countUnder16++;
            }
        }

        double percent = (countUnder16 * 100.0) / n;
        System.out.printf("PERCENTAGE OF PEOPLE UNDER 16: %.1f%%%n", percent);

        sc.close();
    }
}
