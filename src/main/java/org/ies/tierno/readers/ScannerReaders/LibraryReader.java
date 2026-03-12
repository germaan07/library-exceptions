package org.ies.tierno.readers.ScannerReaders;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.model.Book;
import org.ies.tierno.model.Library;
import org.ies.tierno.model.Loan;
import org.ies.tierno.model.Partner;
import org.ies.tierno.readers.Reader;

import java.util.*;

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

        var booksByIsbn = new HashMap<String, Book>();
        var partnersByNif = new HashMap<String, Partner>();
        var loans = new ArrayList<Loan>();

        Integer numBooks = null;
        do {
            try {
                log.info("Introduce el número de LIBROS: ");
                numBooks = scanner.nextInt();
            } catch (InputMismatchException e){
                log.error("El número de LIBROS no puede ser una letra.");
            } finally {
                scanner.nextLine();
            }
        } while (numBooks == null);

        for (int i = 0; i < numBooks; i++){
            var book = bookReader.read();
            booksByIsbn.put(book.getIsbn(), book);
        }

        Integer numPartner = null;
        do {
            try {
                log.info("Introduce el número de SOCIOS: ");
                numPartner = scanner.nextInt();
            } catch (InputMismatchException e){
                log.error("El número de SOCIOS no puede ser una letra.");
            } finally {
                scanner.nextLine();
            }
        } while (numPartner == null);
        for (int i = 0; i < numPartner; i++){
            var partner = partnerReader.read();
            partnersByNif.put(partner.getNif(), partner);
        }

        Integer numLoans = null;
        do {
            try {
                log.info("Introduce el número de SOCIOS: ");
                numLoans = scanner.nextInt();
            } catch (InputMismatchException e){
                log.error("El número de PRÉSTAMOS no puede ser una letra.");
            } finally {
                scanner.nextLine();
            }
        } while (numLoans == null);
        for (int i = 0; i < numLoans; i++){
            var loan = loanReader.read();
            loans.add(loan);
        }

        return new Library(name, booksByIsbn, partnersByNif, loans);

    }
}
