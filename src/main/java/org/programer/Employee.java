package org.programer;

import lombok.Getter;
import lombok.Setter;


public class Employee {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private int salaries;
    @Getter @Setter
    private int yearOfBirth;


    public Employee(String name, String lastName, int salaries, int yearOf_birth) {
        this.name = name;
        this.lastName = lastName;
        this.salaries = salaries;
        this.yearOfBirth = yearOf_birth;
    }

    // Método para obtener el nombre completo del empleado
    public String getFullName() {
        return name + " " + lastName;
    }

    // Método para calcular la edad del empleado
    public int calculateAge() {
        return 2024 - yearOfBirth;
    }

    // Método para calcular el salario ajustado según la edad
    public double calculateAdjustedSalary() {
        double salary = salaries;
        if (calculateAge() > 40) {
            salary += salary * 0.05; // Agregar 5% si el empleado tiene más de 40 años
        }
        return salary;
    }



}
