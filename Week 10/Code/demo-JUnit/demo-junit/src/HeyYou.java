
import java.util.Scanner;


public class HeyYou {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        
        System.out.println("What is your name ? ");
        String name = scanner.nextLine();
        System.out.println(printmessage_name(name)); 
        scanner.close();
    }

    static String printmessage_name( String name ){

        return "Hey " + " " + name;
    }
    
}
