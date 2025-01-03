import java.util.Scanner;


public class DrivingLicense {




    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your age ? ");

        byte age = scanner.nextByte();
        scanner.nextLine();
        boolean boul = false;
        System.out.println("Do you have permission to live in Great Britain (Yes or No)  ?");
        String yes_or_no =  scanner.nextLine();

        if (yes_or_no.equalsIgnoreCase("yes")){
            boul = true;
        }
        else if(yes_or_no.equalsIgnoreCase("no")){
            boul = false;

        }
        else {
            System.out.println("You have to respond either by yes or no at the second question !");
        }


        if (boul == true && age >= 16 ){
            System.out.println("You are eligible for a provisionnal driving license !");
        }
        else {
            System.out.println("You are NOT eligible for a provisionnal driving license !");

        }
        scanner.close();
        

    }
}