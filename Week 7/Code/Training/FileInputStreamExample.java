import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamExample {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            // Create a FileInputStream object to open the file for reading
            fileInputStream = new FileInputStream(args[0]);
            fileOutputStream = new FileOutputStream(args[1]);
            
            int i;

           do {
            i = fileInputStream.read();
            if (i != -1) fileOutputStream.write(i);

           } while (i != -1);
        } catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
            // Ensure the stream is closed to release system resources
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
             try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

