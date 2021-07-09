package com.justtip.backend.exercises;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MacUtils {

    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s: %s";

    private static byte[] encrypt(String message){
        byte[] sender = null;
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("HmacSHA512");
            keygen.init(256);
            SecretKey hmacKey = keygen.generateKey();
            Mac mac = Mac.getInstance("HmacSHA512");
            mac.init(new SecretKeySpec(hmacKey.getEncoded(),"HmacSHA512"));
            mac.update(message.getBytes());
            sender = mac.doFinal();
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }

        return sender;
    }

    private static String bytesToHex(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes){
            sb.append(String.format("%02x",b));
        }
        return sb.toString();
    }

    private static String encrypt(String name, String password, String message){
        
        return null;
    }

    public static void main(String[] args) {
        String pText = "Hello message";
        System.out.println(String.format(OUTPUT_FORMAT, "Input (string)", pText));
        System.out.println(String.format(OUTPUT_FORMAT, "Input (bytes)", bytesToHex(encrypt(pText))));

    }
}
