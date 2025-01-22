import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;





public class FileManager {

    static void read_file(String filepath) throws IOException{
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
            String line;  // try with resources 
            while ( (line = bufferedReader.readLine()) != null){
                    System.out.println(line);
            }
        }
        }


    static void write_file(String filepath) throws IOException{

        try (FileWriter filewriter = new FileWriter(filepath)) {
            filewriter.write("hey coucou I am writing something to the file");
        }
        

    
    }

    public static void main(String[] args) throws IOException{
        String filepath = "the_file.txt";
        write_file(filepath);
        read_file(filepath);

    }
    
}
