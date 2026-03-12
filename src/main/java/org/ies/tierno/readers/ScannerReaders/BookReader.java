package org.ies.tierno.readers.ScannerReaders;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.model.Book;
import org.ies.tierno.readers.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Log4j
public class BookReader implements Reader<Book> {
    private Scanner scanner;

    @Override
    public Book read(){
        String isbn = null;
        String title = null;
        String author = null;
        List<String> genres = new ArrayList<>();
        var cont = true;

        do {
            if (isbn == null){
                log.info("Introduce el ISBN: ");
                isbn = scanner.nextLine();
            } if (title == null){
                log.info("Introduce el TÍTULO: ");
                title = scanner.nextLine();
            } if (author == null){
                log.info("Introduce al AUTOR: ");
                author = scanner.nextLine();
            }
            log.info("Introduce el GÉNERO del libro: ");
            genres.add(scanner.nextLine());

            log.info("¿El libro tiene más géneros?");
            var c = scanner.nextLine();
            if (c.equalsIgnoreCase("n")){
                cont = false;
            } else if (!c.equalsIgnoreCase("s")){
                log.error("Por favor, introduce únicamente S (sí) ó n (no).");
            }
        } while (cont == true);
        return new Book(isbn, title, author, genres);
    }

}
