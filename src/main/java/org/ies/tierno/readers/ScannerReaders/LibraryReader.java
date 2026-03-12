package org.ies.tierno.readers.ScannerReaders;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.model.Book;
import org.ies.tierno.model.Library;
import org.ies.tierno.readers.Reader;

import java.util.Scanner;

@AllArgsConstructor
@Log4j
public class LibraryReader implements Reader<Library> {
    private Scanner scanner;
    private PartnerReader partnerReader;
    private BookReader bookReader;
    private LoanReader loanReader;

    @Override
    public Library read(){
        log.info("Introduce el NOMBRE: ");
        var name = scanner.nextLine();
    }
}
