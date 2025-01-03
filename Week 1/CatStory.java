import java.util.Scanner;


public class CatStory {
    
    public static void main(String[] args){
        
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("What is your cat’s name?\r");
    
            String input = scanner.nextLine();
    
            
            
            String final_message = String.format("""
                What is your cat`s name?
                %s
                Amina strolled through the park with her beloved pet cat, %s, nestled
                comfortably in her arms. %s, with his soft fur and bright green eyes,
                had been her faithful companion for years. As the sun began to set, Amina
                whispered to %s, urging him to head home, their bond stronger than
                ever.
                """, input, input, input, input );

                System.out.println(final_message);
        }


       
        
    }
}
