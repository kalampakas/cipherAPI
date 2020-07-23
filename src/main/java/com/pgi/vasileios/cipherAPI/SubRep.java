package com.pgi.vasileios.cipherAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SubRep implements ICipher  {
    private String name = "Subrep";
    private String mapName = "rot13";

    @Autowired
    private SubstitutionRepository thisRepo;

    /*@Autowired
    public SubstitutionRepository populateRepo() {
        thisRepo.save(new SubstitutionStrings("rot13", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvw",
                "NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm"));
        return thisRepo;
    }*/

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    private final SubstitutionStrings staticStrings = new SubstitutionStrings("rot13", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz",
            "NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm");

    private SubstitutionStrings getCipherMap(String name) {
        /*List<SubstitutionStrings> ss = populateRepo().findByName(name);
        if (ss!=null) {
            System.out.println(ss.get(0).toString());
            return ss.get(0);
        }*/
        return staticStrings;
    }

    public String encrypt(String text) {
        SubstitutionStrings selected = this.getCipherMap(mapName);
        String clearMap = selected.getClearAlphabet();
        String encryptionMap = selected.getCipherAlphabet();
        StringBuilder encryptedText = new StringBuilder();
        Map<Character, Character> cipherMap = new HashMap<>();
        for ( int i=0; i< clearMap.toCharArray().length;i++) {
            cipherMap.put(clearMap.charAt(i), encryptionMap.charAt(i));
        }
        for (char c : text.toCharArray()) {
            if (c != ' ') {
            encryptedText.append(cipherMap.getOrDefault(c,' '));
            } else encryptedText.append(c);
        }
        return encryptedText.toString();
    }

    public String decrypt(String text) {
        SubstitutionStrings selected = this.getCipherMap(mapName);
        String clearMap = selected.getClearAlphabet();
        String encryptionMap = selected.getCipherAlphabet();
        StringBuilder clearText = new StringBuilder();
        Map<Character, Character> cipherMap = new HashMap<>();
        for ( int i=0; i< encryptionMap.toCharArray().length;i++) {
            cipherMap.put(encryptionMap.charAt(i), clearMap.charAt(i));
        }
        for (char c : text.toCharArray()) {
            if (c != ' ') {
                clearText.append(cipherMap.getOrDefault(c,' '));
            } else clearText.append(c);
        }
        return clearText.toString();
    }
}
