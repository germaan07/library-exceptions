package org.ies.tierno.readers.ScannerReaders;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.model.Partner;
import org.ies.tierno.readers.Reader;

import java.util.Scanner;

@AllArgsConstructor
@Log4j
public class PartnerReader implements Reader<Partner> {
    private final Scanner scanner;

    @Override
    public Partner read(){
        String nif = null;
        String name = null;
        String  surname = null;
        Integer numPartner = null;
        Integer zipCode = null;
        do {
            if (nif == null){
                log.info("Introduce el NIF: ");
                nif = scanner.nextLine();
            } else if (name == null){
                log.error("Introduce el nombre: ");
                name = scanner.nextLine();
            } else if (surname == null){
                log.info("Introduce el apellido: ");
                surname = scanner.nextLine();
            } else if (numPartner == null){
                log.info("Introduce el puesto de trabajo: ");
                numPartner = scanner.nextInt();
                scanner.nextLine();
            } else {
                log.info("Introduce el código postal: ");
                zipCode = scanner.nextInt();
                scanner.nextLine();
            }
        } while (zipCode == null);
        return new Partner(nif, name, surname, numPartner, zipCode);
    }
}
