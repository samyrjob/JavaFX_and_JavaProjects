import java.util.Scanner;


public class CylinderVolume {

    double height;
    double radius;

    CylinderVolume(double height, double radius){
        this.height = height;
        this.radius = radius;
    }

    void CalculateVolume(){
        double volume = Math.PI*(Math.pow(this.radius, 2))*this.height;
        String volume_with_2 = String.format("%.2f",volume);
        System.out.println("The volume of a Cylinder with a radius of " + this.radius + " and a height of " + this.height + " is " + volume_with_2);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's calculate the volume of a cylinder");
        System.out.println("Enter his radius please : ");
        double radius = scanner.nextDouble();
        System.out.println("Enter his height please : ");
        double height = scanner.nextDouble();

        CylinderVolume cylinder = new CylinderVolume(height, radius);
        cylinder.CalculateVolume();
        scanner.close();

    }
    
}
