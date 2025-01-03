import Utilities.Calculator;
import java.util.Scanner;


public class MyMaths {
    
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose first value : ");
        Double first_value = scanner.nextDouble();
        System.out.println("Choose second value : ");
        Double second_value = scanner.nextDouble();


        Calculator calculator = new Calculator(first_value, second_value);

        calculator.sum();
        calculator.division();
        calculator.multiplication();
        calculator.substraction();

        scanner.close();
    }
}
