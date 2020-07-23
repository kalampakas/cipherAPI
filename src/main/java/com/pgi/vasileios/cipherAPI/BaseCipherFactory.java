package com.pgi.vasileios.cipherAPI;

public abstract class BaseCipherFactory {
    public abstract ICipher createCipher(String type);
}
