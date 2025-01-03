class SumThread extends Thread{
    int  [] array_int;
    int sum;

    SumThread(int [] array_int){
        this.array_int = array_int;
        this.start();
    }

    @Override
    public void run(){
        int x =0;
        for (int i =0; i<array_int.length; i++){
            x += array_int[i];
        }

        sum =x;
    }
}

class ProductThread extends Thread{
    int  [] array_int;
    int product;

    ProductThread(int [] array_int){
        this.array_int = array_int;
        this.start();
    }

    @Override
    public void  run(){
        int x =1;
        for (int i =0; i<array_int.length; i++){
            x *= array_int[i];
        }
        product = x;
    }
}

class ResultThread extends Thread {

    int sum;
    int product;
    int result;

    ResultThread(int sum, int product){
        this.sum = sum;
        this.product = product;
        this.start();
    }

    @Override
    public void run(){
        result = (sum - product);
        System.out.println("the result is " + result);
    }
}


public class ThreadCalc {

    public static void main(String[] args) {
       int [] arrayA = {1,2,3,4,10,20,50,100,1000,2500,3000};
       int [] arrayB = {2,4,2,4,10,150};

       SumThread sumthread = new SumThread(arrayA);
       ProductThread productthread = new ProductThread(arrayB);
      
       try {
           sumthread.join();
           int sum = sumthread.sum;
           System.out.println(sum);
           productthread.join();
           int pro = productthread.product;
           System.out.println(pro);
           ResultThread resultthread = new ResultThread(sum, pro);
           resultthread.join();

       } catch (InterruptedException ie){
        System.out.println("the main thread has been interrupted");
       }


       
        
    }
    
}
