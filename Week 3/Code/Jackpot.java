// package Code;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Jackpot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;


        HashSet<Integer> unique_set_of_numbers = new HashSet<>();

        ArrayList<Integer> range_1_to_45 = new ArrayList<>(); // // I Ensure this is parameterized with <Integer>
        ArrayList<Integer> User_list = new ArrayList<>();

        for (int i=1; i<= 45; i++){
            range_1_to_45.add(i);
        }

        // FIRST let's implement the choice of the simulator :
        // Shuffle the list of integers
        Collections.shuffle(range_1_to_45);

        // Pick the first 6 numbers
        ArrayList<Integer> Simulator_numbers = new ArrayList<>(range_1_to_45.subList(0, 6));

        System.out.println("\n\n Hey ! Please choose 6 unique numbers between 1 and 45 !\n\n ");

        while(User_list.size() < 6 ){
            System.out.println("Available numbers: " + range_1_to_45 + " \n\n\nYour choice number " + (User_list.size()+ 1)  +" :");
            choice = scanner.nextInt();
            if (range_1_to_45.contains(choice)){
                    range_1_to_45.remove(Integer.valueOf(choice));
                    User_list.add(choice);
            }
            else {
                System.out.println("--------------\nNumber already chosen or in a wrong format or range, please select a different one ! \n-------------");

            }
        }

        for (int number_user : User_list){
            unique_set_of_numbers.add(number_user);

        }
        for (int number_user : Simulator_numbers){
            unique_set_of_numbers.add(number_user);
        }

        int size_of_set = unique_set_of_numbers.size();

        switch (size_of_set) {
            case 6:
                System.out.println("----------\n\nCONGRATULATIONS JACKPOT \n\n\n You got 6 matching numbers ! \n\n\n JAAAAAAACKPOT ! \n\n\n You win \u00A3 6,400,000 !");
                break;
            case 7:
                System.out.println("----------\n\nCONGRATULATIONS \n\n\n You got 5 matching numbers !  \n\n\n You win \u00A3 220,000 !");
                break;
            case 8:
                System.out.println("----------\n\nCONGRATULATIONS \n\n\n You got 4 matching numbers !  \n\n\n You win \u00A3 45,000 !");
                break;
            case 9:
                System.out.println("----------\n\nCONGRATULATIONS \n\n\n You got 3 matching numbers !  \n\n\n You win \u00A3 250 !");
                break;
            case 10:
                System.out.println("----------\n\nCONGRATULATIONS \n\n\n You got 2 matching numbers !  \n\n\n You win \u00A3 10 !");
                break;
            case 11:
                System.out.println("----------You got only 1 matching numbers, but unfortunately you won nothing .... Try again !!!");
                break;
            default:
                System.out.println("----------Sorry Dude... You got 0 matching numbers, .... Try again !!!");
                break;
        }



        scanner.close();
 
    }
    
}
