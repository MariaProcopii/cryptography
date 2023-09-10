package org.example;

import java.util.Arrays;
import java.util.HashMap;

public class Something {
    public static void bubbleSort(int[] array){
        boolean sorted = false;
        while(!sorted){
            sorted = true;

            for(int i = 0; i < array.length - 1; i++){
                if(array[i] > array[i + 1]){
                    sorted = false;
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }

    public static void binarySearch(int[] array, int key){
        int indexFirst = 0;
        int indexLast = array.length - 1;
        int middle = (indexLast + indexFirst)/2;

        while (indexFirst <= indexLast){

            if(key == array[middle]){
                System.out.format("Key %s at index %s", key, middle);
                break;
            }
            else if(key > array[middle]){
                indexFirst++;
            }
            else {
                indexLast--;
            }

            middle = (indexLast + indexFirst)/2;
        }

        if(indexFirst > indexLast){
            System.out.println("Element not found");
        }
    }

    public  static int[] twoSum(int[] array, int target){
        int[] setResult = new int[2];
        boolean found = false;

        A: for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                if(i != j && array[i] + array[j] == target){
                    setResult[0] = i;
                    setResult[1] = j;
                    found = true;
                    break A;
                }
            }
        }
        if(!found){
            System.out.println("Elements not present");
        }
        return setResult;
    }

    public  static boolean palindrome(String string){
        boolean palindrome  = false;
        string = string.toLowerCase();
        StringBuilder newString = new StringBuilder(string);
        newString.reverse();
        if(string.equals(newString.toString())){
            palindrome = true;
        }
        return  palindrome;
    }

    public static boolean uniqueSet(String string){
        string = string.toLowerCase();
        boolean unique = true;
        char[] arrayChar = string.toCharArray();

        A: for (int i = 0; i < arrayChar.length; i++){
            for (int j = 0; j < arrayChar.length; j++){
                if(i != j && arrayChar[i] == arrayChar[j]){
                    unique = false;
                    break A;
                }
            }
        }
        return unique;
    }

    public static HashMap<Character, Integer> countChars(String string){
        string = string.toLowerCase();
        char[] arrayChar = string.toCharArray();
        HashMap<Character, Integer> result =new HashMap<>();

        for(int i = 0; i < arrayChar.length; i++){
            if(!result.containsKey(arrayChar[i])){
                result.put(arrayChar[i], 1);
            }
            else{
                result.put(arrayChar[i], result.get(arrayChar[i]) + 1);
            }
        }
        return result;
    }

    public static int[] closestToZero(int[] array){
        int closestSum = Integer.MAX_VALUE;
        int[] elements = new int[2];

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                int sumAbs = Math.abs(array[i] + array[j]);
                if(i != j && sumAbs < closestSum){
                    closestSum = sumAbs;
                    elements[0] = array[i];
                    elements[1] = array[j];
                }
            }
        }
        Arrays.stream(elements).forEach(System.out::println);
        return elements;
    }

    public static void primeNumber(int number){

        boolean isPrime = true;

        for(int i = 2; i <= number; i++){
            if(number % i == 0 && i != number){
                isPrime =  false;
            }
        }

        if(isPrime && number != 1){
            System.out.format("Number %s is prime \n", number);
        }
        else{
            System.out.format("Number %s is not prime \n", number);
        }

    }
}
