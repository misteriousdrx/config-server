package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.encryption.CipherEnvironmentEncryptor;
import org.springframework.cloud.config.server.encryption.EnvironmentEncryptor;
import org.springframework.cloud.config.server.encryption.SingleTextEncryptorLocator;
import org.springframework.cloud.config.server.encryption.TextEncryptorLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.TextEncryptor;

@Configuration
public class envCrypt {

    @Autowired
    private TextEncryptorLocator locator;

    @Autowired
    private TextEncryptor textCrypt;


    @Bean
    public EnvironmentEncryptor environmentEncryptor() {

        TextEncryptorLocator locator = this.locator;
        if (locator == null) {
            locator = new SingleTextEncryptorLocator(textCrypt);
        }
        return new CipherEnvironmentEncryptor(locator);
    }

}
