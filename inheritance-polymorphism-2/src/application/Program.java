package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);

            if (ch == 'c' || ch == 'C') {
                System.out.print("Name: ");
                sc.nextLine(); // consome quebra de linha
                String name = sc.nextLine();

                System.out.print("Price: ");
                double price = sc.nextDouble();

                Product commonProduct = new Product(name, price);
                list.add(commonProduct);
            }
            else if (ch == 'u' || ch == 'U') {
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();

                System.out.print("Price: ");
                double price = sc.nextDouble();

                System.out.print("Manufacture date (dd/MM/yyyy): ");
                sc.nextLine();
                String dateStr = sc.nextLine();
                Date manufactureDate = sdf.parse(dateStr);

                Product usedProduct = new UsedProduct(name, price, manufactureDate);
                list.add(usedProduct);
            }
            else if (ch == 'i' || ch == 'I') {
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();

                System.out.print("Price: ");
                double price = sc.nextDouble();

                System.out.print("Customs fee: ");
                double fee = sc.nextDouble();

                Product importedProduct = new ImportedProduct(name, price, fee);
                list.add(importedProduct);
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product p : list) {
            System.out.println(p.priceTag());
        }

        sc.close();
    }
}
