package Utilities;

public class Calculator {

    Double a;
    Double b;

    public Calculator(double a1, double b1){
        a = a1;
        b = b1;
    }

    public void sum(){
        System.out.println("a + b = " + (a+b));
    }

    public void substraction(){
        System.out.println("a - b = " + (a-b));
    }

    public void multiplication(){
        System.out.println("a * b = " + (a*b));
    }
    public void division(){
        if (b ==0){
            System.out.println("b equals 0 so we cannot divide by it");
        }
        else {System.out.println("a / b = " + (a/b));
    }
    }
    
}
