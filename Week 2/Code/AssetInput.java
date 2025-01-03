import java.util.Scanner;

public class AssetInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter a uppercase character letter please : ");
        char upper_char = scanner.next().charAt(0);
        System.out.println("enter three digits please : ");
        short three_digit = scanner.nextShort();
        scanner.nextLine(); // because nextShort() it only takes the numerical short values not the \n when we press Enter !
        System.out.println("enter a sequence of five lowercase letters : ");
        String sequence_s = scanner.nextLine();
        System.out.println("Your valid code is " + upper_char+ three_digit + sequence_s);

        scanner.close();

    }
}
