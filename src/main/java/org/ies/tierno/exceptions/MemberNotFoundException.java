package org.ies.tierno.exceptions;

public class MemberNotFoundException extends Exception {
    private final String nif;

    public MemberNotFoundException(String nif) {
        super("El SOCIO con NIF: " + nif + ", no existe.");
        this.nif = nif;
    }
}
