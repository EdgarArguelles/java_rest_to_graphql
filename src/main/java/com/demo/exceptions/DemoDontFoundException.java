package com.demo.exceptions;

public class DemoDontFoundException extends RuntimeException {

    /**
     * Constructs a new exception with the specified user readable message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    public DemoDontFoundException(String message) {
        super(message);
    }
}