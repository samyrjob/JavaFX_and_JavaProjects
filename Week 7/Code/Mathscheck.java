import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Mathscheck {

    public static void main(String args []) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            try {
                System.out.println("Press a first integer ");
                String input_user = reader.readLine();
                int int_1 = Integer.parseInt(input_user);
                System.out.println("Press a second integer ");
                input_user = reader.readLine();
                int int_2 = Integer.parseInt(input_user);
                System.out.println("the result of " + int_1 + "/" + int_2 + " is equal to " + (int_1 / int_2));
    
            }
            catch (ArithmeticException ea){
                System.out.println("Enter valid input again");
            }
        }



    }


}
