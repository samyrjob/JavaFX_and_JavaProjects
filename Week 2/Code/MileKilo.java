import java.util.Scanner;

public class MileKilo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of Miles ");
        double mile = scanner.nextDouble();
        if (mile > 0){
            System.out.println(mile + " miles" + "is equal to " + mile*1.609 + " Km");
        }
        else {
            System.out.println(" 0 Km");
        }
       
        scanner.close();



    }
    
}
