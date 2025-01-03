import java.util.Scanner;




public class CestrianInsurance {
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        short total_payable = 0;
        byte age;
        byte penalty;

        System.out.println("------------------\t WELCOME TO CESTRIAN INSURANCE LIMITED\t ---------------");
        System.out.println("What kind of vehicle do you want to insure?");
        System.out.println("Type 1 for Car\nType 2 for a Motorcycle");
        
        byte user_type = scanner.nextByte(); // Read vehicle type
        System.out.println("How many penalty points do you have (you can type for example '6')? ");
        penalty = scanner.nextByte(); // Read penalty points
        System.out.println("What is your age (you can type for example '25')? ");
        age = scanner.nextByte(); // Read age

        if (user_type == 1) {
            total_payable += 305; // Car base price
            if (penalty > 6) {
                total_payable += 100; // Penalty for more than 6 points
            }
            if (age < 25) {
                total_payable += 150; // Example penalty for under 25
            }
        } else if (user_type == 2) { // Change from 1 to 2
            total_payable += 360; // Motorcycle base price
            if (penalty > 6) {
                total_payable += 100; // Penalty for more than 6 points
            }
            if (age < 25) {
                total_payable += 150; // Example penalty for under 25
            }
        } else {
            System.out.println("Enter a correct choice of vehicle please!");
            scanner.close();
            return; // Exit if the input is invalid
        }

        // Print the total payable amount
        System.out.println("Total amount payable for insurance: " + total_payable + " \u00A3");
        
        scanner.close();
    }
}
