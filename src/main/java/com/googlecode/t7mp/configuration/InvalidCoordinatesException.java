package com.googlecode.t7mp.configuration;

@SuppressWarnings("serial")
public class InvalidCoordinatesException extends RuntimeException {

    public InvalidCoordinatesException(String coordinates) {
        super("Could not create a dependency from " + coordinates);
    }
}
