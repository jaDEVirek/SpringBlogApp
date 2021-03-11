package com.devirek.blogapp.configuration;


import com.devirek.blogapp.exceptions.BlogAppSecurityException;
import io.jsonwebtoken.Jwts;
import lombok.SneakyThrows;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.util.Optional;

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

    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                   .setSubject(principal.getUsername())
                   .signWith(getPrivateKey())
                   .compact();
    }

    /**
     * For getting same private key per each object
     *
     * @return private key
     */

    @SneakyThrows
    private PrivateKey getPrivateKey() {
        return Optional.of((PrivateKey) keyStore.getKey("springblog", "secret".toCharArray()))
                       .orElseThrow(() -> new BlogAppSecurityException(
                               "Exception occured while retrieving public key from keystore"));
    }


}
