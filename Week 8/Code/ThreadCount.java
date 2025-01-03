class DisplayEvenAndOddNumbers {

    String state;
    int x1 = 1; // odd 
    int x2 = 2; // even

    synchronized void displayEvenNumbers(boolean running ){
        if (!running){ // we stop the display
            state = "counting_even";
            notify(); // notify any waiting thread 
            return;
        }

        System.out.println(x2);
        x2 += 2;

        state = "counting_even"; // set the current state to counting_even
        
        notify(); // let displayOddNumbers to run 
        
        try {
            while (!state.equals("counting_odd")){
                wait();
            }
        } catch (InterruptedException io){
            io.printStackTrace();
        }
    }

    synchronized void displayOddNumbers(boolean running ){
        if (!running){ // we stop the display
            state = "counting_odd";
            notify(); // notify any waiting thread 
            return;
        }

        System.out.println(x1);
        x1 += 2;

        state = "counting_odd"; // set the current state to counting_even
        
        notify(); // let displayOddNumbers to run 
        
        try {
            while (!state.equals("counting_even")){
                wait();
            }
        } catch (InterruptedException io){
            io.printStackTrace();
        }
    }



}




class MyThread implements Runnable {

    Thread thrd;
    DisplayEvenAndOddNumbers the_object_en_question;


    // constructor to create aMyThread object
   MyThread(String name, DisplayEvenAndOddNumbers object_en_question){
        thrd = new Thread(this, name);
        the_object_en_question = object_en_question;
    }

    // Start and create a Thread

    // here test if I can use it or no if I remove public PLEAAAAAAASE
    public static MyThread start_and_create(String name, DisplayEvenAndOddNumbers object_en_question){
       MyThread myThread = new MyThread(name, object_en_question);

       myThread.thrd.start();
        return myThread;
    }


    public void run(){
        if (thrd.getName().compareTo("counting_odd") == 0){
            for (int i = 0; i<8; i++){
                the_object_en_question.displayOddNumbers(true);
            }
            the_object_en_question.displayOddNumbers(false);
        }
        else{
            for (int i = 0; i<8; i++){
                the_object_en_question.displayEvenNumbers(true);
            }
            the_object_en_question.displayEvenNumbers(false);
        }


    }

    
}


public class ThreadCount {

    public static void main(String[] args) {

        DisplayEvenAndOddNumbers the_objet = new DisplayEvenAndOddNumbers();

        MyThread mt1 = MyThread.start_and_create("counting_odd", the_objet);
        MyThread mt2 = MyThread.start_and_create("counting_even", the_objet);

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException ie){
            System.out.println("Main thread interrupted");
        }

        
    }
}