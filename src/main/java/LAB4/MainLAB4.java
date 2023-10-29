package LAB4;

import java.util.Arrays;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class MainLAB4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String choice;

            System.out.println("(1): Find the K plus");
            System.out.println("(2): Find D and C for specific i");
            System.out.println("(3): Find round Key for specific i");
            System.out.println("(4): Find all round keys from 8-character key");
            System.out.println("(x): Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();


            if(choice.equals("x")){
                break;
            }

            switch (choice){
                case "1": {
                    System.out.print("Enter an 8-character key: ");
                    String input = scanner.nextLine();


                    if (input.length() != 8) {
                        System.out.println("Key must be 8 characters long. Please try again.");
                        break;
                    }
                    System.out.println("K+ ==> " + KeyGeneration.applyPC1permutation(input));
                    break;
                }
                case "2": {
                    System.out.print("Enter a K plus: ");
                    String Kplus = scanner.nextLine();
                    System.out.print("Enter i: ");
                    String i = scanner.nextLine();

                    KeyGeneration.findAllDandC(Kplus);
                    KeyGeneration.printSpecificCandD(Integer.parseInt(i));
                    break;
                }
                case "3": {
                    System.out.print("Enter a K plus: ");
                    String Kplus = scanner.nextLine();
                    System.out.print("Enter i: ");
                    String i = scanner.nextLine();
                    KeyGeneration.findAllDandC(Kplus);
                    KeyGeneration.printSpecificCandD(Integer.parseInt(i));
                    KeyGeneration.applyPC2Permutation();
                    KeyGeneration.printSpecificRoundKey(Integer.parseInt(i));
                    break;
                }
                case "4": {
                    System.out.print("Enter an 8-character key: ");
                    String input = scanner.nextLine();


                    if (input.length() != 8) {
                        System.out.println("Key must be 8 characters long. Please try again.");
                        break;
                    }

                    KeyGeneration.fromStringKeyGetRoundKeys(input);
                    break;
                }
            }
        }
        scanner.close();
    }
}
