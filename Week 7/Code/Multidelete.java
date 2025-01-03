import java.io.IOException;
import java.io.File;

public class Multidelete {

    public static void main(String[] args) {
        try {

            File directory_MyData = new File("MyData");

            if (directory_MyData.exists() && directory_MyData.isDirectory()){
                File [] list_files = directory_MyData.listFiles();
                for (File file : list_files){
                    file.delete();
                }
            }
            else {
                throw new IOException();
            }

        }
        catch (IOException eIoException){

        }
    }
    
}
