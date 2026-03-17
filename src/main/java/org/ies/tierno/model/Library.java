package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.exceptions.BookNotFoundException;
import org.ies.tierno.exceptions.MemberNotFoundException;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@Log4j
public class Library {
    private String name;
    private Map<String, Book> booksByIsbn;
    private Map<String, Partner> partnersByNif;
    private List<Loan> loans;

    public void showBooks(){
        booksByIsbn.values().forEach(Book::showInfo);
    }

    public void showPartners(){
        partnersByNif.values().forEach(Partner::showInfo);
    }

    private boolean existBook(String isbn){
        return null != booksByIsbn.get(isbn);
    }

    public Book findBook(String isbn) throws BookNotFoundException{
        if (existBook(isbn)){
            return booksByIsbn.get(isbn);
        }
        throw new BookNotFoundException(isbn);
    }

    private boolean existPartner(String nif){
        return null != partnersByNif.get(nif);
    }

    public Partner findPartner(String nif) throws MemberNotFoundException {
        var part = partnersByNif.get(nif);
        if (part == null){
            throw new MemberNotFoundException(nif);
        } return part;
    }

    public boolean partnerLendBook(String isbn, String nif){
        return loans.stream()
                .anyMatch(loan -> loan.getIsbn().equalsIgnoreCase(isbn) && loan.getNif().equals(isbn));
    }
}
