package com.madsj.exception;

public class UnknownCommandException extends Exception{

    public UnknownCommandException(String operator) {
        super("Unknown command! '" + operator + "'");
    }
}
