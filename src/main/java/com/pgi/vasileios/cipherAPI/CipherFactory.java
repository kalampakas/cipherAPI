package com.pgi.vasileios.cipherAPI;

public class CipherFactory extends BaseCipherFactory {

    @Override
    public ICipher createCipher(String type) {
        ICipher cipher;
        switch (type.toLowerCase() )
        {
            case "caesar":
                cipher = new Caesar();
                break;
            case "passthrough":
                cipher = new Passthrough();
                break;
            case "subrep":
                SubRep sr = new SubRep();
                sr.setMapName("rot13");
                cipher = sr;
                break;
            default: throw new IllegalArgumentException("No such cipher");
        }
        System.out.println("Implementing " + cipher.getClass().toString());
        return cipher;
    }
}
