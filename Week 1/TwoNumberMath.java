import java.util.Scanner;





public class TwoNumberMath {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number : ");

        String first_number = scanner.nextLine();

        System.out.print("Enter Second number : ");

        String second_number = scanner.nextLine();

        int sum = Integer.parseInt(first_number) + Integer.parseInt(second_number);
        int sous = Integer.parseInt(first_number) - Integer.parseInt(second_number);
        int div = Integer.parseInt(first_number)  / Integer.parseInt(second_number);
        int mul = Integer.parseInt(first_number) *  Integer.parseInt(second_number);

        System.out.println(first_number + " + "  + second_number  + " = " + sum );
        System.out.println(first_number + " - "  + second_number  + " = " + sous );
        System.out.println(first_number + " / "  + second_number  + " = " + div );
        System.out.print(first_number + " * "  + second_number  + " = " + mul );

        scanner.close();


    }
    
}
