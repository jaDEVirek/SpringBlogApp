package com.devirek.blogapp.configuration;


import com.devirek.blogapp.exceptions.BlogAppSecurityException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@Service
public class JWTDataProvider {

    private KeyStore keyStore;

    @PostConstruct
    public void initData() {
        try (InputStream resourceAsStream = getClass().getResourceAsStream("/springblog.jks")) {
            keyStore = KeyStore.getInstance("JKS");
            keyStore.load(resourceAsStream, "secret".toCharArray());
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            throw new BlogAppSecurityException("Exception occured while loading keystore");
        }
    }
}
