package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data
@AllArgsConstructor
@Log4j
public class Partner {
    private String nif;
    private String name;
    private String surname;
    private int numPartner;
    private int zipCode;

    public void showInfo(){
        log.info("  SOCIO");
        log.info("  NIF - " + nif);
        log.info("  NOMBRE - " + name);
        log.info("  APELLIDO - " + surname);
        log.info("  NÚMERO DE SOCIO - " + numPartner);
        log.info("  CÓDIGO POSTAL - " + zipCode);
    }
}
