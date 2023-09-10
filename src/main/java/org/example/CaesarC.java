package org.example;

import java.util.HashMap;

public class CaesarC {
    static HashMap<String, Integer> alphabet = new HashMap<>();

    public static void makeAlpha(){
        for(int i = 0; i < 26; i ++){
            char c = (char) (i + 'A');
            alphabet.put(String.valueOf((c)), i);
        }
    }

    public static String encrypt(String message, int key) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
                char encrChar = (char) ((c - 'A' + key) % 26 + 'A');
                encryptedMessage.append(encrChar);
            }

        System.out.println(encryptedMessage);
        return encryptedMessage.toString();
    }

    public static String decrypt(String message, int key) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            char decrChar = (char) ((c - 'A' - key + 26) % 26 + 'A');
            decryptedMessage.append(decrChar);
        }

        System.out.println(decryptedMessage);
        return decryptedMessage.toString();

    }

    public static void main(String[] args) {
        makeAlpha();
    }

}

