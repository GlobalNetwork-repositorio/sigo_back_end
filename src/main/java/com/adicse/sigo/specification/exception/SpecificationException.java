package com.adicse.sigo.specification.exception;

@SuppressWarnings("serial")
public class SpecificationException extends RuntimeException {
    public SpecificationException() {
    }

    public SpecificationException(String string) {
        super(string);
    }

    public SpecificationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpecificationException(Throwable cause) {
        super(cause);
    }

}
