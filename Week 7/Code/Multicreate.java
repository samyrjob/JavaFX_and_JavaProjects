import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashSet;


public class Multicreate {

    public static void main(String[] args) {

        DecimalFormat decimalformat = new DecimalFormat("00");
       

        HashSet<String> all_files = new HashSet<>();

       
            try {
                for (int i = 0; i<15; i++){
                    String filename = String.format("BigData%s.dat",decimalformat.format(i+1));
                    all_files.add(filename);
                }
                
                File folder = new File("MyData");
                if (!folder.exists()){
                    if (folder.mkdir()){
                        System.out.println("the folder " + folder.getName() + " was successfully created" );
                    }
                    else{
                        System.out.println("fail to create the folder " + folder.getName());
                    }
                }
                else {
                    System.out.println("the folder " + folder.getName() + " already exists");
                }
                
                for (String filename : all_files){
                    File file = new File(folder, filename);
                    if (file.createNewFile()){
                        System.out.println("file created successfully");
                    } else {
                        System.out.println("File already exists: " + file.getName());
                    }
                }
            }
            catch (IOException eo){
                System.out.println("Exception occured to create the file : ");
            }

        }
    }
    

