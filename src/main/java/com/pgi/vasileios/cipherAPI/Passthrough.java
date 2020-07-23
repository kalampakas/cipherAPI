package com.pgi.vasileios.cipherAPI;


import org.springframework.stereotype.Component;

@Component
public class Passthrough implements ICipher {
    private String name = "Passthrough";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String encrypt(String text) {
        return text.toUpperCase();
    }

    public String decrypt(String text) {
        return text.toLowerCase();
    }
}
