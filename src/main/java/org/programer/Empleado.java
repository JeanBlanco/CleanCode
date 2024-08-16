package org.programer;

import lombok.Getter;
import lombok.Setter;


public class Empleado {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private int salaries;
    @Getter @Setter
    private int yearOf_birth;

    public Empleado() {
    }

    public Empleado(String name, String lastName, int salaries, int yearOf_birth) {
        this.name = name;
        this.lastName = lastName;
        this.salaries = salaries;
        this.yearOf_birth = yearOf_birth;
    }

    // Método para obtener el nombre completo del empleado
    public String getFullName() {
        return name + " " + lastName;
    }
}
