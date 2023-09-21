package LAB3;

import java.util.Scanner;

public class MainLAB3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String choice;

            System.out.println("(e): Encryption");
            System.out.println("(d): Decryption");
            System.out.println("(x): Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            while (true){
                if(choice.equals("e") || choice.equals("d") || choice.equals("x")){
                    break;
                }
                else{
                    System.out.println("[Invalid choice. You can pick just (e) (d) (x)]");
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextLine();
                }
            }
            if(choice.equals("x")){
                break;
            }
            scanningProcess(scanner, choice);
        }
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

    private static boolean isValidKey(String key) {
        return key.length() >= 7;
    }

    private static void scanningProcess(Scanner scanner, String choice){

        System.out.println("[Are allowed only characters (A-Z, a-z).]");
        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        message = message.replace(" ", "").toUpperCase();

        while (!isValidMessage(message)){
            System.out.println("[Invalid characters. Are allowed only characters (A-Z, a-z).]");
            System.out.print("Enter your message: ");
            message = scanner.nextLine().replace(" ", "").toUpperCase();
        }

        String key = null;
            System.out.println("[Are allowed only characters (A-Z, a-z), length >= 7.]");
            System.out.print("Enter your key: ");
            key = scanner.nextLine();

            key = key.replace(" ", "").toUpperCase();

            while (!(isValidMessage(key) && isValidKey(key))){
                System.out.println("[Invalid choice. Are allowed only characters (A-Z, a-z), length >= 7.]");
                System.out.print("Enter your key: ");
                key = scanner.nextLine().replace(" ", "").toUpperCase();
            }

        switch (choice) {
            case "e" -> VigenereCipher.encrypt(message, key);
            case "d" -> VigenereCipher.decrypt(message, key);
        }
    }
}
