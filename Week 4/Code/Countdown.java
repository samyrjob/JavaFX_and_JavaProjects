import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Countdown {


    public static void printCountdown(int start) {
  
            while (start > 0){
                System.out.println(start + ", ");
                start--;
            }
            System.out.println(start );





    }


    public static void main(String[] args) {


        ArrayList<Integer> array_5_to_20 = new ArrayList<>(Arrays.asList(5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));

        Scanner scanner = new Scanner(System.in);
        int chosen_number;

        for (;;){
            System.out.println("Enter a number between 5 and 20 :");
            chosen_number = scanner.nextInt();
            
            if (array_5_to_20.contains(chosen_number)) {
                break;
            }
    
        }
        printCountdown(chosen_number);
        scanner.close();
    }
}
