import java.util.Scanner;





public class AddTen {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number : ");

        double number_inserted = scanner.nextDouble();

        double number_result = number_inserted + 10;

        System.out.print(  number_inserted + " + 10 " + " = " + number_result);

        scanner.close();


    }
    
}
