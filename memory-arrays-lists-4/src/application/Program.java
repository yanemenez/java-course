package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employee = new ArrayList<>();
        System.out.print("How many employees will be registered: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            System.out.println("Employee #" + (i + 1) + ":");
            System.out.print("Id: ");
            Integer id = sc.nextInt();

            while (hasId(employee, id)) {
                System.out.print("Id already taken! Try again: ");
                id = sc.nextInt();
            }

            sc.nextLine(); // limpa o buffer
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);
            employee.add(emp);
        }

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();

        Employee emp = employee.stream().filter(e -> e.getId() == id).findFirst().orElse(null);

        if (emp != null) {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        } else {
            System.out.println("This id does not exist.");
        }

        System.out.println();
        System.out.println("List of employees:");
        for (Employee e : employee) {
            System.out.println(e);
        }

        sc.close();
    }

    public static boolean hasId(List<Employee> list, int id) {
        return list.stream().anyMatch(e -> e.getId() == id);
    }
}
