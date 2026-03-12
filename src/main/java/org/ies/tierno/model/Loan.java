package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Log4j
public class Loan {
    private String isbn;
    private LocalDate loanDate;
    private String nif;
    private LocalDate returnDate;

    public void showInfo(){
        log.info("      PRÉSTAMO");
        log.info("    ISBN del LIBRO - " + isbn);
        log.info("    FECHA DE PRÉSTAMO - " + loanDate);
        log.info("    NIF del SOCIO - " + nif);
        log.info("    FECAH DE DEVOLUCIÓN - " + returnDate);
    }
}
