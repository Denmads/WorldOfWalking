package com.madsj.response;

public class ErrorResponse implements Response{

    private final String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    @Override
    public String print() {
        return message;
    }
}
