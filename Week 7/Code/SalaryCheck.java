import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SalaryCheck {

    public static void main(String[] args) {

    
      

        while (true){
            boolean exceptionOccurred = false;
            try {
                System.out.println(" Enter annual salary (£):");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                
                String user_input = bufferedReader.readLine();
                int user_converted_int = Integer.parseInt(user_input);
                if (user_converted_int < 0){
                    throw  new IOException();
                }
                else if (user_converted_int >= 0){
                    System.out.println("-------------------\r\n" + //
                                            "Your salary is " + "\u00A3" + user_converted_int );
                }
    
            }
            catch (IOException eo){
                
                System.out.println(" Invalid salary entry. Please enter a positive value.");
                exceptionOccurred = true;
    
            }
            finally {
                if (exceptionOccurred == false){
                    break;
                }
    
            }

        }
    }
}