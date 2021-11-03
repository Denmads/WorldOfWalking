package com.madsj.response;

public class ErrorResponse implements Response{

    private final Exception error;

    public ErrorResponse(Exception error) {
        this.error = error;
    }

    @Override
    public void print() {
        System.out.println(error.getMessage());
    }
}
