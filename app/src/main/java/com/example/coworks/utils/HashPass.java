package com.example.coworks.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPass {

    public static String hashPassword(String password){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodeHash = digest.digest(password.getBytes());
            return bytesHex(encodeHash);
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }
    }

    private static String bytesHex(byte[] hash){
        StringBuilder hexString = new StringBuilder(2 * hash.length);

        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
