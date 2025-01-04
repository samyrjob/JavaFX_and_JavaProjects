import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


class OrangeJuice{

    public static void calculationBottle(int response_ml, Map<Integer, String> map_bottles) 
    {
        int [] bottle_quantities = {2000, 1000, 500, 200, 125};
       
         // from keyboard


        for (int i = 0; i<5; i++){
            if(response_ml >= bottle_quantities[i]){
                    int remainder = response_ml % bottle_quantities[i];
                    int quotient = ((response_ml - remainder)/bottle_quantities[i]);
                    map_bottles.put(bottle_quantities[i], quotient + "x " + bottle_quantities[i]  + "ml (full)");

                    if (remainder == 0 ){
                        
                        break;
                    }

                    else if (remainder >= 200 ){
                            calculationBottle(remainder, map_bottles);
                    }

                    else if (remainder < 200){
                                                
                        if (remainder > 125 ){

                            // 175
                            // 1 x 125 ml (filled)
                            // 1 x 125 ml (part filled)

                            map_bottles.put(125, "1 x  125  ml (full)\n1 x  125  ml (semi-filled)");
                            // we need 2 bottles !     
                        }
                        else if (remainder == 125) {
                            map_bottles.put(125, "1 x  125  ml (full)");
                        }
                        else {
                            map_bottles.put(125, "1 x  125  ml (semi-filled)");
                            
                            // we need  one
                        }
                    }
                    break;

            }
      }





    }      



    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        while (true){ 
        System.out.println("How much orange juice do you want (in millilitres)?:" );
        int response_ml = scanner.nextInt();
        if (125 <= response_ml && response_ml <= 5000){
            System.out.println(" You need the following bottles:");



            Map<Integer, String> map_bottles = new HashMap<>();
            calculationBottle(response_ml, map_bottles);

            int [] bottle_quantities = {2000, 1000, 500, 200, 125};
            for (int i : bottle_quantities){
                if (map_bottles.get(i) != null){
                    System.out.println(map_bottles.get(i));
                }
                
        
              }


            System.out.println("Enjoy your juice!");
            break;
           
        }
        else {
            System.out.println("You have entered an invalid ammount. Please choose again");

    }
           

        
    }

    }
}