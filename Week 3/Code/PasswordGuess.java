package Code;

import java.util.Scanner;

public class PasswordGuess {
        public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String user_input = "random";
     

        do {
            System.out.println("What is the correct password ?");
            user_input = scanner.nextLine();
        } while ( !user_input.equals("open-sesame"));

        System.out.println("Congrats ! You are now connected !");

        scanner.close();



    }
    
}
