import java.util.Scanner;

public class FourLetters {
     public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a four-letter word of your choice ");
        String words = scanner.nextLine();
        char[] word = words.toCharArray();
        System.out.println(word[0]);
        System.out.println(word[1]);
        System.out.println(word[2]);
        System.out.println(word[3]);
       
        scanner.close();



    }
    
}
