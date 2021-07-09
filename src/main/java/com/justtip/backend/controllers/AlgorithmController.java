package com.justtip.backend.controllers;

import com.n1analytics.paillier.PaillierPrivateKey;
import com.n1analytics.paillier.PaillierPublicKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.KeyPair;
import java.security.SecureRandom;

@Controller
public class AlgorithmController {

    @GetMapping("utilities")
    public String getPrime(){
        return "algo/utilities";
    }

    @GetMapping("shorturl")
    public String shortUrl(){
        return "algo/shorturl";
    }

    public String homomorphic(){

        int KEY_SIZE = 1024; //number of bits
        SecureRandom r = new SecureRandom();
//        Paillier p = new PaillierKeyPairGenerator();
//        p.initialize(KEY_SIZE, r);
//        KeyPair pe = p.generateKeyPair();
//        PaillierPublicKey pk = (PaillierPublicKey) pe.getPublic();
//        PaillierPrivateKey sk = (PaillierPrivateKey) pe.getPrivate();

        return "algo/homomorphic";
    }
}
