
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;




// in this example, we attach Runnable to inner-classes
// not the main class itself 
class LyricsThread
{
   public static void main(String args[]) throws InterruptedException {
	  
	 Thread lyrics1 = new Thread(new Thread1());
	 Thread lyrics2 = new Thread(new Thread2());
	 lyrics1.start();
     lyrics1.join();
	 lyrics2.start();
     lyrics2.join();
   }
   


   private static class Thread1 implements Runnable {
    String filePath = "lyrics1.txt";

    public void run(){
        try ( BufferedReader bufferedreader = new BufferedReader( new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))){

           
            String line;
            while ((line = bufferedreader.readLine()) != null){
                System.out.println(line);
                Thread.sleep(1000);
            }


        } catch (IOException | InterruptedException io){
            io.printStackTrace();
        }


    }





   }

      private static class Thread2 implements Runnable {

            public void run(){

                try ( BufferedReader bufferedreader = new BufferedReader(new FileReader("lyrics2.txt"))){

           
                    String line;
                    while ((line = bufferedreader.readLine()) != null){
                        System.out.println(line);
                        Thread.sleep(1000);
                    }
        
        
                } catch (IOException | InterruptedException io){
                    io.printStackTrace();
                }
        
    }





   }
}