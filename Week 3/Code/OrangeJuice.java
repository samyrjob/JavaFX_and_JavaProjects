// package Code;

import java.util.Scanner;



public class OrangeJuice {

    public static short [] boucle(short a, short [] sizes_reversed, short [] nb_bottles){
        for (int i = 0; i<sizes_reversed.length; i++){
            if (sizes_reversed[i] <= a){
                short quotient = (short) (a/sizes_reversed[i]);
                nb_bottles[i] += quotient;
                a = (short) (a % sizes_reversed[i]);
                if (a == 0){
                    break;
                }
            }
        }
        if (a > 0){
            nb_bottles[nb_bottles.length - 1] += 1;
        }
        return nb_bottles;
    }


    public static void main(String args[]){

        short [] sizes_reversed = {2000, 1000, 500, 200, 125};
        short nb_bottle_2000 = 0;
        short nb_bottle_1000 = 0;
        short nb_bottle_500 = 0;
        short nb_bottle_200 = 0;
        short nb_bottle_125 = 0;
        short nb_bottle_125_not_full =0;
        short [] nb_bottles = {nb_bottle_2000, nb_bottle_1000, nb_bottle_500, nb_bottle_200, nb_bottle_125, nb_bottle_125_not_full};

    
        Scanner scanner = new Scanner(System.in);
        short userValue;

        while (true) {
            System.out.print("\"How much orange juice do you want ( in millilitres) ? \" Please enter a value between 125 and 5000: ");
            userValue = scanner.nextShort();

            // Check if the input is within the valid range
            if (userValue >= 125 && userValue <= 5000) {
                System.out.println(userValue);
                break; // Exit the loop if the input is valid
            } else {
                System.out.println("Invalid input. Please try again."); // Prompt the user again
            }
        }



        nb_bottles = boucle(userValue, sizes_reversed, nb_bottles);
    
    

        System.out.println("You need the following bottles : \n");
        for (int  i =0; i<nb_bottles.length - 2 ; i++ ){
            if (nb_bottles[i] != 0){
                System.out.println(nb_bottles[i] + " x " + sizes_reversed[i] + " ml  (full)");
            }
        }

        if(nb_bottles[nb_bottles.length - 1] != 0){
            System.out.println(nb_bottles[nb_bottles.length - 1] + " x 125 ml  (part filled)");

        }
        System.out.println("Enjoy your juice !");


        scanner.close();
        

    }
}