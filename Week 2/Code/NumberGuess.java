import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        
        byte a;
        byte guess = 5;
        Scanner scanner = new Scanner(System.in);
        System.out.println("You must guess a number between 1 and 20 ");
        a = scanner.nextByte();
        scanner.nextLine();
        System.out.print("Your guess is ");
        System.out.print(a==guess);
        scanner.close();

    }
}
