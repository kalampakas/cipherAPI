package com.pgi.vasileios.cipherAPI;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarTest {

    @Test
    void encrypt() {
        String txt = "My test string";
        ICipher testCipher = new Caesar();
        Assertions.assertThat(testCipher.encrypt(txt)).isEqualTo("Zl grfg fgevat");
    }

    @Test
    void decrypt() {
        String txt = "Zl grfg fgevat";
        ICipher deCipher = new Caesar();
        Assertions.assertThat(deCipher.decrypt(txt)).isEqualTo("Zl grfg fgevat");
    }
}