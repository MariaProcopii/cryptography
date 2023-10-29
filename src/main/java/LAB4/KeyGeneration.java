package LAB4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class KeyGeneration {

    public static final int[] PC1 = {
            57, 49, 41, 33, 25, 17, 9,
            1, 58, 50, 42, 34, 26, 18,
            10, 2, 59, 51, 43, 35, 27,
            19, 11, 3, 60, 52, 44, 36,
            63, 55, 47, 39, 31, 23, 15,
            7, 62, 54, 46, 38, 30, 22,
            14, 6, 61, 53, 45, 37, 29,
            21, 13, 5, 28, 20, 12, 4
    };
    public static final int[] PC2 = {
            14, 17, 11, 24, 1, 5,
            3, 28, 15, 6, 21, 10,
            23, 19, 12, 4, 26, 8,
            16, 7, 27, 20, 13, 2,
            41, 52, 31, 37, 47, 55,
            30, 40, 51, 45, 33, 48,
            44, 49, 39, 56, 34, 53,
            46, 42, 50, 36, 29, 32
    };

    public static final int[] shift = {
            1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1
    };

    static HashMap<Integer, String> collectionOfC = new HashMap<>();
    static HashMap<Integer, String> collectionOfD = new HashMap<>();
    static HashMap<Integer, String> collectionOfAll16Keys = new HashMap<>();
    static String Kplus;

    //K+
    public static String applyPC1permutation(String stringKey) {
        String bitForm = fromLettersToBits(stringKey);
        char[] output = new char[PC1.length];
        for (int i = 0; i < PC1.length; i++) {
            output[i] = bitForm.charAt(PC1[i] - 1);
        }
        Kplus = new String(output);
        return Kplus;
    }

    private static String fromLettersToBits(String stringKey) {
        StringBuilder result = new StringBuilder();
        for (char c : stringKey.toCharArray()) {
            result.append(String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0'));
        }
        System.out.println("From the key string to bit format: " + result);
        return result.toString();
    }

    //collection of all D and C
    public static void findAllDandC(String Kplus) {
        String leftHalf = Kplus.substring(0, 28); //C
        String rightHalf = Kplus.substring(28); //D

        for (int round = 1; round <= 16; round++) {
            leftHalf = circularLeftShift(leftHalf, shift[round - 1]);
            rightHalf = circularLeftShift(rightHalf, shift[round - 1]);
            collectionOfC.put(round, leftHalf);
            collectionOfD.put(round, rightHalf);
        }
    }

    private static String circularLeftShift(String input, int shiftAmount) {
        return input.substring(shiftAmount) + input.substring(0, shiftAmount);
    }

    //collection of all round Keys
    public static void applyPC2Permutation(){
        for (int round = 1; round <= 16; round++) {
            String subKey = collectionOfC.get(round) + collectionOfD.get(round);
            char[] output = new char[PC2.length];
            for (int i = 0; i < PC2.length; i++) {
                output[i] = subKey.charAt(PC2[i] - 1);
            }
            collectionOfAll16Keys.put(round, new String(output));
        }
    }

    public static void printSpecificCandD(int i){
        System.out.println("C" + i + " ==> " + collectionOfC.get(i));
        System.out.println("D" + i + " ==> " + collectionOfD.get(i));
    }

    public static void printSpecificRoundKey(int i){
        System.out.println("K" + i + " ==> " + collectionOfAll16Keys.get(i));
    }

    public static void fromStringKeyGetRoundKeys(String stringKey){
        applyPC1permutation(stringKey); // K+
        findAllDandC(Kplus);  // all D and C from K+
        applyPC2Permutation(); // all round keys

        Iterator<Map.Entry<Integer, String>> iterator = collectionOfAll16Keys.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> val = iterator.next();
            System.out.println("K" + val.getKey() + " ==> " + val.getValue());
        }
    }
}