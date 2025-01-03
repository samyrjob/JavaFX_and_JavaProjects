package Code;
import java.util.Scanner;


public class TaxCalc {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        double user_input =0;
        double tax_result;

        do {
            System.out.println("What is your monthly income in pounds ?");
            user_input = scanner.nextDouble();
            if (user_input <= 1500){
                tax_result = 0.2*user_input;
            }
            else {
                tax_result = 0.3*user_input;
            }
            System.out.println("You should pay " + tax_result + " as taxes");
        } while ( user_input != -99);

        System.out.println("Tax calculations have now ended !");

        scanner.close();



    }
    
}
