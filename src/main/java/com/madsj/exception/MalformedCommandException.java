package com.madsj.exception;

public class MalformedCommandException extends Exception{
    public MalformedCommandException(String operator, String expected, String actual) {
        super("Malformed command '" + operator + "'! Expected: " + expected + " | Actual: " + actual);
    }
}
