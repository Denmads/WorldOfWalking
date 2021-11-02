package com.madsj.exception;

import java.util.List;

public class WrongNumberOfArgumentsException extends Exception{
    public WrongNumberOfArgumentsException(String operator, String expected, String actual) {
        super("Wrong number of arguments for command '" + operator + "'! Expected: " + expected + " | Actual: " + actual);
    }
}
