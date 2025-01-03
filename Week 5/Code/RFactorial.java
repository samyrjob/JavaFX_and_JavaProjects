


public class RFactorial{

    static int factorial(int i){

        int result = 1;

        if (i == 0){
            result = 1;
        }
        else{
            result = i*factorial(i-1);
        }
        return result;
        
    }


    public static void main(String[] args) {
        
        int babouche = factorial(5);
        System.out.println(babouche);

    }
}