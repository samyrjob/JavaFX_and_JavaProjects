
import java.util.Scanner;

class MyThread extends Thread{

    public void run(){
        
    
            try {
                for (int i = 0; i<9; i++){
                    System.out.println(i+1);
    
                    Thread.sleep(1000);
                
                    // Check if the thread is interrupted
                    if (Thread.interrupted()) {
                        System.out.println("Countdown aborted!");
                        return;
                    }
                }
                System.out.println(" Lift Off!");
                
            } catch (InterruptedException IO){
                System.out.println("Countdown aborted!");
            }
        

    }
}


public class AbortCountDown {
    public static void main(String args[]){

        MyThread mythread = new MyThread();
        mythread.start();

        try {

            Thread.sleep(1000);

        } catch (InterruptedException ie){
            ie.printStackTrace();
        }


        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 0 if you want to interrupt the thread (the CountDown) " + mythread.getName());
        while (true){
            String input = scanner.nextLine();
            if ("0".equals(input)){
                mythread.interrupt();
                break;
            }
        scanner.close();

        }


    
    
    }


}
