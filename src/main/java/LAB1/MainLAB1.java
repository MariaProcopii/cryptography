package LAB1;


import java.util.Scanner;

public class MainLAB1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

            System.out.println("(e): Encryption with 1 key");
            System.out.println("(d): Decryption with 1 key");
            System.out.println("(E): Encryption with 2 keys");
            System.out.println("(D): Decryption with 2 keys");

            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();


            while (true){
                if(choice.equals("E") || choice.equals("D") || choice.equals("e") || choice.equals("d")){
                    break;
                }
                else{
                    System.out.println("[Invalid choice. You can pick just (E) (d) (E) (D)]");
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

    private static boolean isValidKey2(String key2) {
        return key2.length() >= 7;
    }

    private static boolean isValidKey(int key){
        if(key > 25 || key < 1){
            return false;
        }
        return true;
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

        String key2 = null;
        if(choice.equals("E") || choice.equals("D")){
            System.out.println("[Are allowed only characters (A-Z, a-z), length >= 7.]");
            System.out.print("Enter your key2: ");
            key2 = scanner.nextLine();

            key2 = key2.replace(" ", "").toUpperCase();

            while (!(isValidMessage(key2) && isValidKey2(key2))){
                System.out.println("[Invalid choice. Are allowed only characters (A-Z, a-z), length >= 7.]");
                System.out.print("Enter your key2: ");
                key2 = scanner.nextLine().replace(" ", "").toUpperCase();
            }
        }

        System.out.println("[Valid key should be between 1 and 25.]");
        System.out.print("Enter the key: ");
        int key = scanner.nextInt();

        while (!isValidKey(key)){
            System.out.println("[Invalid choice. Valid key should be between 1 and 25.]");
            System.out.print("Enter the key: ");
            key = scanner.nextInt();
        }

        switch (choice) {
            case "e" -> CaesarC.encrypt(message, key);
            case "d" -> CaesarC.decrypt(message, key);
            case "E" -> CaesarC.encrypt(message, key, key2);
            case "D" -> CaesarC.decrypt(message, key, key2);
        }
    }
}
