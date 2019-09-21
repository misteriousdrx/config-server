package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.encrypt.TextEncryptor;


@Configuration
@Primary
public class textCrypt implements TextEncryptor {
    @Override
    public String encrypt(String text) {
        return "lalala";
    }

    @Override
    public String decrypt(String encryptedText) {
        return "lala";
    }
}
