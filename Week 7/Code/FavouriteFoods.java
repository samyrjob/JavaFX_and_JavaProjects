import java.util.Scanner;
import java.util.HashSet;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FavouriteFoods {

    static Scanner scanner = new Scanner(System.in);
    static HashSet<String> set_favorite_foods = new HashSet<>();


    public static void read_append_file(File file) throws IOException{
        Scanner scanner_read = new Scanner(file);
        System.err.println("\n\n Now let's see what are the three favourite foods you picked :  ");

        while (scanner_read.hasNextLine()){
            String line_in_file = scanner_read.nextLine();
            System.out.println(line_in_file);
        }
        scanner_read.close();


    }


    public static void main(String[] args) {

        System.out.println("You will have to tell me what are your best three top fodds \r\n");
        System.out.println("what is your Third favourite food : ");
        String choice_1 = scanner.nextLine();
        set_favorite_foods.add(choice_1);
        System.out.println("what is your second favourite food : ");
        choice_1 = scanner.nextLine();
        set_favorite_foods.add(choice_1);
        System.out.println("what is your first favourite food : ");
        choice_1 = scanner.nextLine();
        set_favorite_foods.add(choice_1);
        System.out.println("Choose the name of the file you want to save this list ? ");
        String filename = scanner.nextLine();
        
        
        try {
            String filename_with_extension = String.format("%s.txt", filename);
            File file = new File(filename_with_extension);

            if (file.createNewFile()){
                System.out.println("New file " + filename + " created successfully ! ");
                FileWriter fwrite = new FileWriter(filename_with_extension);
                BufferedWriter bufferedWriter = new BufferedWriter(fwrite);

                for (String element : set_favorite_foods){
                    bufferedWriter.write(element);
                    bufferedWriter.newLine();
                }
                
                bufferedWriter.close();
                fwrite.close();
                System.out.println("Do you want to read the content of that file ? press 1 if so.");
                int pressed_number = scanner.nextInt();
                if (pressed_number == 1){
                    read_append_file(file);
                }
                System.out.println("Do you want to add two more favourite foods in the list ? press 1 if so.");
                pressed_number = scanner.nextInt();
                scanner.nextLine();
                if (pressed_number == 1){
                    FileWriter fwrite2 = new FileWriter(filename_with_extension, true);
                    System.out.println("what is your fourth favourite food : ");
                    String choice_2 = scanner.nextLine();
                    fwrite2.write(choice_2 + "\r\n");
                    System.out.println("what is your fifth favourite food : ");
                    choice_2 = scanner.nextLine();
                    fwrite2.write(choice_2);
                    fwrite2.close();
                }
                scanner.close();
            }
            else {
                System.out.println(filename + "already exists");
            }

           
        }
        catch (IOException ea){
            ea.printStackTrace();

        }




    }
    
}
