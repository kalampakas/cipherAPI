package com.pgi.vasileios.cipherAPI;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import java.lang.reflect.InvocationTargetException;

@RestController
public class RequestController {
    CipherFactory cf = new CipherFactory();


    @PostMapping(path="/api/v1/encode/{cipher}", consumes = "text/plain; charset: utf-8")
    public Request encode(@PathVariable String cipher, @RequestBody String text) {
        ICipher actualCipher = cf.createCipher(cipher);
        return new Request (String.format("%s", actualCipher.encrypt(text)));
    }

    @PostMapping(path="/api/v1/decode/{cipher}", consumes = "text/plain; charset: utf-8")
    public Request decode(@PathVariable String cipher, @RequestBody String text) {
        ICipher actualCipher = cf.createCipher(cipher);
        return new Request (String.format("%s", actualCipher.decrypt(text)));
    }
}
