import java.util.Scanner;

public class MonthDays {
        public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
    

        System.out.println(" enter the name of one of the twelve months of the year");
   
        String month = scanner.nextLine();

        switch (month.toLowerCase()) {
            case "january":
            case "march":
            case "may":
            case "july":
            case "august":
            case "october":
            case "december":
                System.out.println("There are 31 days in " + month);
                break;
            case "april":
            case "june":
            case "september":
            case "november":
                System.out.println("There are 30 days in " + month);
                break;
            default:
                System.out.println("Please enter a correct month !");
                break;
        }
        
        scanner.close();
    }
    
}
