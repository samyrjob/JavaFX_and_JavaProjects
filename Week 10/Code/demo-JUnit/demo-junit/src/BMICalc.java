import java.util.Scanner;


public class BMICalc {


    public static double generate_BMI(float weight, float height) {
        
        double BMI = (weight / Math.pow(height,2));
        System.out.println("Your Body Mass Index is " + BMI );
        return BMI;
    }
}













