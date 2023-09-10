package org.example;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

            System.out.println("(E): Encryption ");
            System.out.println("(D): Decryption");

            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();


            while (true){
                if(choice.equals("E") || choice.equals("D")){
                    break;
                }
                else{
                    System.out.println("Invalid choice.");
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextLine();
                }
            }

            scanningProcess(scanner, choice);
            scanner.close();
        }

    private static boolean isValidMessage(String message) {

        for (char c : message.toCharArray()) {
            if (!((c >= 'A' && c <= 'Z'))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidKey(int key){
        if(key > 25 || key < 1){
            return false;
        }
        return true;
    }

    private static void scanningProcess(Scanner scanner, String choice){
        System.out.println("Are allowed only characters (A-Z, a-z)");
        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        message = message.replace(" ", "").toUpperCase();

        while (!isValidMessage(message)){
            System.out.println("Invalid characters. Are allowed only characters (A-Z, a-z)");
            System.out.print("Enter your message: ");
            message = scanner.nextLine().replace(" ", "").toUpperCase();
        }

        System.out.println("Valid key should be between 1 and 25");
        System.out.print("Enter the key: ");
        int key = scanner.nextInt();

        while (!isValidKey(key)){
            System.out.println("Valid key should be between 1 and 25");
            System.out.print("Enter the key: ");
            key = scanner.nextInt();
        }

        if(choice.equals("E")){
            CaesarC.encrypt(message,key);
        } else if (choice.equals("D")) {
            CaesarC.decrypt(message, key);
        }
    }
}
