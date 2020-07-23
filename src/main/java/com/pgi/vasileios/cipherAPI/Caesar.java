package com.pgi.vasileios.cipherAPI;


import org.springframework.stereotype.Component;

import static java.lang.Character.*;

@Component
public class Caesar implements ICipher {
    private String name = "Caesar";
    private int rot = 13;
    private int alphabetsize = 26;

    public int getAlphabetSize() {
        return alphabetsize;
    }

    public void setAlphabetSize(int alphabetsize) {
        this.alphabetsize = alphabetsize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRot() {
        return rot;
    }

    public void setRot(int rot) {
        this.rot = rot;
    }

    private String actualEncrypt(String text, int offset,int size) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (character != ' ') {
                if (isLowerCase(character)) {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % size;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else if (isUpperCase(character)){
                    int originalAlphabetPosition = character - 'A';
                    int newAlphabetPosition = (originalAlphabetPosition + offset) % size;
                    char newCharacter = (char) ('A' + newAlphabetPosition);
                    result.append(newCharacter);
                } else if (isDigit(character)){
                    result.append(character);
                }
            } else result.append(character);
        }
        return result.toString();
    }

    public String encrypt(String text) {
        return actualEncrypt(text, this.getRot(), this.getAlphabetSize());
    }

    public String decrypt(String text) {
        return actualEncrypt(text,
                (this.getAlphabetSize() - ( this.getRot() % this.getAlphabetSize())),
                this.getAlphabetSize());

    }
}
