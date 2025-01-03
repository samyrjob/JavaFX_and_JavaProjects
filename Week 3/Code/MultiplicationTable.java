import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        byte [] to_10 = {1,2,3,4,5,6,7,8,9,10};
        byte [] to_12 = {1,2,3,4,5,6,7,8,9,10, 11, 12};
        System.out.println("Enter a number between 1 and 10");
        byte number_entered = scanner.nextByte();
        boolean found = false;

        for (int number : to_10){
            if (number == number_entered){
                found = true;
            }
        }


        if (found == true) {
            for (int num : to_12){
                System.out.println(num + " \u0078 " + number_entered + " = " + num*number_entered );
                
            }
        } else {
            System.out.println("You really should enter a numbet between 1 and 10 ! ");
        }
        scanner.close();

    

        }    }
