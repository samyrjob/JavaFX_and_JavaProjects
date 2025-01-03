import java.util.Arrays;
import java.util.Scanner;


public class Scores {

    static Scanner scanner = new Scanner(System.in);

    static int[] array_scores = new int[5];
    // or write static int[] array_scores = {0,0,0,0,0} to avoid error NullPointerException 


    public static void main(String[] args) {


        for (int i =0; i<5; i++){
            System.out.println("Give the score between 1 and 10 of judge number " + (i+1));
            int score_judge = scanner.nextInt();
            array_scores[i] = score_judge;

        }

        Arrays.sort(array_scores);
        System.out.println(Arrays.toString(array_scores));
  
         // Display the smallest and largest scores
         System.out.println("Smallest score: " + array_scores[0]);
         System.out.println("Largest score: " + array_scores[array_scores.length - 1]);

        
        
    }
    
}
