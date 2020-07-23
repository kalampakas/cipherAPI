package com.pgi.vasileios.cipherAPI;

public class Request {

    private final String text;

    public Request(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}