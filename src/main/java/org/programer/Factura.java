package org.programer;

import lombok.Getter;
import lombok.Setter;

public class Factura {
    @Getter @Setter
    private String invoceNumber;
    @Getter @Setter
    private int amount;
    @Getter @Setter
    private Empleado emp;

    public Factura() {
    }

    public Factura(String invoceNumber, int amount, Empleado emp) {
        this.invoceNumber = invoceNumber;
        this.amount = amount;
        this.emp = emp;
    }
}
