package LAB3;

import java.util.*;

public class VigenereCipher {
    static LinkedHashMap<Character, Integer> findInt = new LinkedHashMap<>();
    static ArrayList<Character> alphabet = new ArrayList<>();

    public static void encrypt(String text, String key){
        StringBuilder encryptedMessage = new StringBuilder();

        if(alphabet.size() == 0){
            getAlphabet();
        }

        for(int i = 0; i < text.length(); i++){
            int textCharCode = findInt.get(text.charAt(i));
            int keyCharIndex = i % key.length();
            char keyChar = key.charAt(keyCharIndex);
            int keyCharCode = findInt.get(keyChar);

            int encryptedCharIndex = (textCharCode + keyCharCode)%31;
            char encryptedChar = alphabet.get(encryptedCharIndex);
            encryptedMessage.append(encryptedChar);
        }
        System.out.println("\n" + encryptedMessage);
    }

    public static void decrypt(String text, String key){
        StringBuilder decryptedMessage = new StringBuilder();
        if(alphabet.size() == 0){
            getAlphabet();
        }

        for(int i = 0; i < text.length(); i++){
            int textCharCode = findInt.get(text.charAt(i));
            int keyCharIndex = i % key.length();
            char keyChar = key.charAt(keyCharIndex);
            int keyCharCode = findInt.get(keyChar);

            int decryptedCharIndex = (textCharCode - keyCharCode + 31) % 31;
            char decryptedChar = alphabet.get(decryptedCharIndex);
            decryptedMessage.append(decryptedChar);
        }
        System.out.println("\n" + decryptedMessage);
    }

    public static void getAlphabet() {

        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            alphabet.add(c);
        }
        alphabet.add(19,'Ș');
        alphabet.add(21,'Ț');
        alphabet.add(1, 'Ă');
        alphabet.add(2, 'Â');
        alphabet.add(11,'Î');

        for(int i = 0; i <=30; i++){
            findInt.put(alphabet.get(i), i);
        }
//        findInt.entrySet().forEach(c -> System.out.println(c.getKey() + ":" + c.getValue() + "; "));
    }
}