package Code;
import java.util.Scanner;


public class TimeGreeting {




    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the current time in the 24-hour clock format (e.g., 1430 or 815) ");

        short user_time = scanner.nextShort();
        scanner.nextLine();

        if (700 <= user_time && user_time <= 1159){
            System.out.println("Good Morning ! ");
            
        } else if (1200 <= user_time && user_time <= 1700 ){
            System.out.println("Good Afternoon !");
        }
        else if (1701 <= user_time && user_time <= 2000 ){
            System.out.println("Good evening !");

        }
        else if (2001 <= user_time && user_time <= 659 ){
            System.out.println("Good Night !");

        }
        else {
            System.out.println("Enter a correct format please !");
        }


        scanner.close();
        

    }
}