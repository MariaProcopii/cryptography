package LAB1;

import java.util.*;

public class CaesarC {
    static HashMap<String, Integer> findInt = new HashMap<>();
    static HashMap<Integer, String> findChar = new HashMap<>();

    static HashMap<String, Integer> findIntShift = new HashMap<>();
    static HashMap<Integer, String> findCharShift = new HashMap<>();


    public static String encrypt(String message, int key) {
        makeAlpha();
        StringBuilder encryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            int code = findInt.get(String.valueOf(c));
            int encrInt = ( code + key ) % 26;
            encryptedMessage.append(findChar.get(encrInt));
            }

        System.out.println(encryptedMessage);
        return encryptedMessage.toString();
    }

    public static String encrypt(String message, int key, String key2){

        shiftAlpha(key2);
        StringBuilder encryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            int code = findInt.get(String.valueOf(c));
            int encrInt = ( code + key ) % 26;
            encryptedMessage.append(findCharShift.get(encrInt));
        }

        System.out.println(encryptedMessage);
        return encryptedMessage.toString();

    }

    public static String decrypt(String message, int key) {
        makeAlpha();
        StringBuilder decryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            int code = findInt.get(String.valueOf(c));
            int decrInt = (code - key + 26) % 26 ;
            decryptedMessage.append(findChar.get(decrInt));
        }

        System.out.println(decryptedMessage);
        return decryptedMessage.toString();
    }

    public static String decrypt(String message, int key, String key2) {
        shiftAlpha(key2);
        StringBuilder decryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            int code = findIntShift.get(String.valueOf(c));
            int decrInt = (code - key + 26) % 26 ;
            decryptedMessage.append(findChar.get(decrInt));
        }

        System.out.println(decryptedMessage);
        return decryptedMessage.toString();
    }

    public static void makeAlpha(){
        for(int i = 0; i < 26; i ++){
            char c = (char) (i + 'A');
            findInt.put(String.valueOf((c)), i);
            findChar.put(i, String.valueOf((c)));
        }
    }

    public static void shiftAlpha(String key2){
        makeAlpha();
        key2 = key2.toUpperCase();
        LinkedHashSet<String> uniqueChar = new LinkedHashSet<>(); //chars from key2
        for(char c : key2.toCharArray()){
            uniqueChar.add(String.valueOf(c));
        }

        ArrayList<String> uniqueCharArray = new ArrayList<>(uniqueChar);

        for(int i = 0; i < uniqueCharArray.size(); i++){
            findCharShift.put(i, uniqueCharArray.get(i));
            findIntShift.put(uniqueCharArray.get(i), i);
        }

        int count = uniqueCharArray.size();
        for(int i = 0; i < 26; i++){
            if(!uniqueCharArray.contains(findChar.get(i))){
                findCharShift.put(count, findChar.get(i));
                findIntShift.put(findChar.get(i), count);
                count++;
            }
        }
    }
}

