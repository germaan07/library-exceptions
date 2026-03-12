package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Data
@AllArgsConstructor
@Log4j
public class Book {
    private String isbn;
    private String title;
    private String author;
    private List<String> genres;

    public void showInfo(){
        log.info("LIBRO");
        log.info("ISBN - " + isbn);
        log.info("TÍTULO - " + title);
        log.info("AUTOR - " + author);
        log.info("GÉNEROS - " + genres.toString());
    }
}
