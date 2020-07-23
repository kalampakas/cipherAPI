package com.pgi.vasileios.cipherAPI;

public interface ICipher {

    String encrypt(String cleanText);
    String decrypt(String cipherText);

}
