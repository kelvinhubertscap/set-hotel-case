package com.capgemini.core;

public class TourTypeException extends Exception{

    public TourTypeException() {
    }

    public TourTypeException(String message) {
        super(message);
    }

    public TourTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public TourTypeException(Throwable cause) {
        super(cause);
    }

    public TourTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
