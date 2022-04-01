package com.ejercicio.contabilidad.exception;

public class AccountException extends Exception{
    private static final long serialVersionUID = 1L;



    public AccountException (String messageException) {

        super(messageException);
    }
}
