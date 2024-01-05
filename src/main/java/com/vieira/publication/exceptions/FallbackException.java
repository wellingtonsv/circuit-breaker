package com.vieira.publication.exceptions;

public class FallbackException extends RuntimeException {

    public FallbackException(Throwable cause){
        super("Estamos com indiponibilidade no momento, por favor tente novamente mais tarde. ", cause);
    }
}
