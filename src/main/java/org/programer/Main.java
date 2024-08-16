package org.programer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Empleado> employees = createEmployees();
        List<Factura> invoices = generateInvoices(employees);

        double totalSalaries = calculateTotalSalaries(employees);
        System.out.println("Total salaries: " + totalSalaries);

        Empleado highestPaidEmployee = findHighestPaidEmployee(employees);
        if (highestPaidEmployee != null) {
            StringBuilder highestSalaryInfo = new StringBuilder()
                    .append("Employee with highest salary: ")
                    .append(highestPaidEmployee.getFullName())
                    .append(", Salary: ")
                    .append(highestPaidEmployee.getSalaries());
            System.out.println(highestSalaryInfo.toString());
        }

        long validInvoicesCount = countValidInvoices(invoices);
        System.out.println("Valid Invoices: " + validInvoicesCount);
    }

    private static double calculateTotalSalaries(List<Empleado> employees) {
        return employees.stream()
                .mapToDouble(Main::calculateAdjustedSalary)
                .sum();
    }

    private static Empleado findHighestPaidEmployee(List<Empleado> employees) {
        return employees.stream()
                .max(Comparator.comparingDouble(Main::calculateAdjustedSalary))
                .orElse(null);
    }

    private static long countValidInvoices(List<Factura> invoices) {
        return invoices.stream()
                .filter(Main::isValidInvoice)
                .count();
    }

    private static double calculateAdjustedSalary(Empleado employee) {
        int age = 2024 - employee.getYearOf_birth();
        double salary = employee.getSalaries();
        if (age > 40) {
            salary += salary * 0.05; // Agregar 5% si el empleado tiene más de 40 años
        }
        return salary;
    }

    private static boolean isValidInvoice(Factura invoice) {
        return invoice.getAmount() > 1000 &&
                invoice.getEmp() != null &&
                invoice.getEmp().getSalaries() > 60000;
    }

    private static List<Empleado> createEmployees() {
        return Arrays.asList(
                new Empleado("John", "Doe", 50000, 1975),
                new Empleado("Jane", "Smith", 60000, 1985),
                new Empleado("Jim", "Beam", 70000, 1990)
        );
    }

    private static List<Factura> generateInvoices(List<Empleado> employees) {
        return Arrays.asList(
                new Factura("INV001", 1500, employees.get(0)),
                new Factura("INV002", 2500, employees.get(1)),
                new Factura("INV003", 3500, employees.get(2))
        );

    }
}

/*
 * Total salarial: 18250
 * Employes: Jim Beam, Salary: 70000
 * valid Invoices: 1
 */

// El autor de esta segunda version es Jean Carlos Blanco Rosero