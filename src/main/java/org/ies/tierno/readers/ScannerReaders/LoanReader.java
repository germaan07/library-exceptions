package org.ies.tierno.readers.ScannerReaders;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.model.Loan;
import org.ies.tierno.readers.Reader;

import java.time.LocalDate;
import java.util.Scanner;

@AllArgsConstructor
@Log4j
public class LoanReader implements Reader<Loan> {
    private Scanner scanner;

    @Override
    public Loan read(){
        String isbn = null;
        var loandate = LocalDate.now();
        String nif = null;
        var returnDate = LocalDate.ofYearDay(loandate.getYear(), loandate.getDayOfMonth()-2);

        do {
            if (isbn == null){
                log.info("Introduce el ISBN: ");
                isbn = scanner.nextLine();
            }
            if (isbn != null){
                log.info("Introduce el NIF: ");
                nif = scanner.nextLine();
            }
        } while (nif == null);

        return new Loan(isbn, loandate, nif, returnDate);
    }
}
