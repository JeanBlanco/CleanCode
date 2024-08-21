package org.programer;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
public class Invoice {
    @Getter @Setter
    private String invoiceNumber;
    @Getter @Setter
    private int amount;
    @Getter @Setter
    private Optional<Employee> emp;

    public Invoice(String invoiceNumber, int amount, Employee emp) {
        this.invoiceNumber = invoiceNumber;
        this.amount = amount;
        this.emp = Optional.ofNullable(emp); // Permite que emp sea nulo y lo convierte en Optional
    }

    // Método para validar si la factura es válida
    public boolean isValidInvoice() {
        return amount > 1000 && emp.isPresent() && emp.get().getSalaries() > 60000;
    }


}
