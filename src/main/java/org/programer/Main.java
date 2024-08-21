package org.programer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class Main {
        public static void main(String[] args) {
            List<Emplayee> employees = createEmployees();
            List<Invoce> invoices = generateInvoices(employees);

            double totalSalaries = calculateTotalSalaries(employees);
            System.out.println("Total salaries: " + totalSalaries);

            Optional<Emplayee> highestPaidEmployee = findHighestPaidEmployee(employees);
            highestPaidEmployee.ifPresent(employee -> {
                StringBuilder highestSalaryInfo = new StringBuilder()
                        .append("Employee with highest salary: ")
                        .append(employee.getFullName())
                        .append(", Salary: ")
                        .append(employee.calculateAdjustedSalary());
                System.out.println(highestSalaryInfo);
            });

            long validInvoicesCount = countValidInvoices(invoices);
            System.out.println("Valid Invoices: " + validInvoicesCount);
        }

        private static double calculateTotalSalaries(List<Emplayee> employees) {
            return employees.stream()
                    .mapToDouble(Emplayee::calculateAdjustedSalary)
                    .sum();
        }

        private static Optional<Emplayee> findHighestPaidEmployee(List<Emplayee> employees) {
            return employees.stream()
                    .max(Comparator.comparingDouble(Emplayee::calculateAdjustedSalary));
        }

        private static long countValidInvoices(List<Invoce> invoices) {
            return invoices.stream()
                    .filter(Invoce::isValidInvoice)
                    .count();
        }

        private static List<Emplayee> createEmployees() {
            return Arrays.asList(
                    new Emplayee("John", "Doe", 50000, 1975),
                    new Emplayee("Jane", "Smith", 60000, 1985),
                    new Emplayee("Jim", "Beam", 70000, 1990)
            );
        }

        private static List<Invoce> generateInvoices(List<Emplayee> employees) {
            return Arrays.asList(
                    new Invoce("INV001", 1500, employees.get(0)),
                    new Invoce("INV002", 2500, employees.get(1)),
                    new Invoce("INV003", 3500, employees.get(2))
            );
        }
    }

/*
 * Total salarial: 18250
 * Employes: Jim Beam, Salary: 70000
 * valid Invoices: 1
 */

// El autor de esta segunda version es Jean Carlos Blanco Rosero