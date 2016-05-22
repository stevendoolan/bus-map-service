package com.github.stevendoolan.busmap.model;

/**
 * Created by Steven Doolan on 22/05/2016.
 */
public class ServiceException extends Exception {

    public ServiceException(String message, Exception cause) {
        super(message, cause);
    }

}
