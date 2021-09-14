package com.weatherInformation.customException;

public class InvalidRangeException extends Exception {
    public InvalidRangeException(String msg) {
        super(msg);
    }
}
