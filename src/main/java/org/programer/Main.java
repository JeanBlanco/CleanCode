package org.programer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class Main {
        public static void main(String[] args) {
            List<Employee> employees = createEmployees();
            List<Invoice> invoices = generateInvoices(employees);

            double totalSalaries = calculateTotalSalaries(employees);
            System.out.println("Total salaries: " + totalSalaries);

            Optional<Employee> highestPaidEmployee = findHighestPaidEmployee(employees);
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

        private static double calculateTotalSalaries(List<Employee> employees) {
            return employees.stream()
                    .mapToDouble(Employee::calculateAdjustedSalary)
                    .sum();
        }

        private static Optional<Employee> findHighestPaidEmployee(List<Employee> employees) {
            return employees.stream()
                    .max(Comparator.comparingDouble(Employee::calculateAdjustedSalary));
        }

        private static long countValidInvoices(List<Invoice> invoices) {
            return invoices.stream()
                    .filter(Invoice::isValidInvoice)
                    .count();
        }

        private static List<Employee> createEmployees() {
            return Arrays.asList(
                    new Employee("John", "Doe", 50000, 1975),
                    new Employee("Jane", "Smith", 60000, 1985),
                    new Employee("Jim", "Beam", 70000, 1990)
            );
        }

        private static List<Invoice> generateInvoices(List<Employee> employees) {
            return Arrays.asList(
                    new Invoice("INV001", 1500, employees.get(0)),
                    new Invoice("INV002", 2500, employees.get(1)),
                    new Invoice("INV003", 3500, employees.get(2))
            );
        }
    }

/*
 * Total salarial: 18250
 * Employes: Jim Beam, Salary: 70000
 * valid Invoices: 1
 */

// El autor de esta segunda version es Jean Carlos Blanco Rosero