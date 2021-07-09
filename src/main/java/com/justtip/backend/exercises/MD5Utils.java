package com.justtip.backend.exercises;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s: %s";

    private static byte[] digest(byte[] input){
        MessageDigest md = null;
        try{
           md = MessageDigest.getInstance("MD5");
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        byte[] result = md.digest(input);
        return result;
    }

    private static String bytesToHex(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes){
            sb.append(String.format("%02x",b));
        }
        return sb.toString();
    }

    private static byte[] checksum(String filepath){
        MessageDigest md = null;
        try{
            md = MessageDigest.getInstance("MD5");
            InputStream is = new FileInputStream(filepath);
            DigestInputStream dis = new DigestInputStream(is,md);
            md = dis.getMessageDigest();
        }catch (Exception e){
           e.printStackTrace();
        }
        assert md != null;
        return md.digest();
    }

    public static void main(String[] args){
        String pText = "Hello MD5";
        System.out.println(String.format(OUTPUT_FORMAT, "Input (string)", pText));
        System.out.println(String.format(OUTPUT_FORMAT, "Input (length)", pText.length()));

        byte[] md5InBytes = MD5Utils.digest(pText.getBytes(UTF_8));
        System.out.println(String.format(OUTPUT_FORMAT, "MD5 (hex)",bytesToHex(md5InBytes)));
        System.out.println(String.format(OUTPUT_FORMAT, "MD5 (length)",md5InBytes.length));

        String filepath = "/Users/xdeveloper/Desktop/data_science_book.pdf";
        System.out.println(String.format(OUTPUT_FORMAT, "File Path (file)",filepath));
        System.out.println(String.format(OUTPUT_FORMAT, "MD5 (checksum)",bytesToHex(checksum(filepath)) ));

    }
}
