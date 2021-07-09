package com.justtip.backend.exercises;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import java.security.Key;
import java.security.SecureRandom;

public class MacAlgo {

    public static void main(String[] args){
        try{
            // initialize key generator
            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            // generate random
            SecureRandom secureRandom = new SecureRandom();
            keyGen.init(secureRandom);
            // create key
            Key key = keyGen.generateKey();
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(key);

            String msg = "hello world";
            byte[] bytes = msg.getBytes();
            byte[] macResult = mac.doFinal(bytes);

            System.out.println("Mac result " + new String(macResult));

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
