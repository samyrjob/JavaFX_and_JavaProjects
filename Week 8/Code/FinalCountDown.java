

public class FinalCountDown {




    public static void main(String args[]){

        for (int i = 10; i>0; i--){

            System.out.println(i);
            try {

                Thread.sleep(1000);
            } catch (InterruptedException IO){
                IO.printStackTrace();
            }
        }
        System.out.println(" Lift Off!");

    }
}
