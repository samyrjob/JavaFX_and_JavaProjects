import java.text.NumberFormat;
import java.util.Scanner;

class VAT {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter value to calculate cost (inc.VAT): ");
        double cost = calcIncVAT(input.nextDouble());
        input.close();
        // output value in currency format
        System.out.println("Cost: "+NumberFormat.getCurrencyInstance().format(cost));
        }

        static double calcIncVAT(double val) {
            if (val <=0) {
                throw new ArithmeticException("Zero or less");
            }
            else {
                final double rate = 0.2;
                return (val*rate)+val;
            }
    }
}
