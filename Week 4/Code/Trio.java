import java.util.ArrayList;
import java.util.Scanner;


class Triangle {

    int length_1;
    int length_2;
    int length_3;

    Triangle(int length_1, int length_2, int length_3){
        this.length_1 = length_1;
        this.length_2 = length_2;
        this.length_3 = length_3;
    }

    int perimeter(){
        int perim = this.length_1 + this.length_2 + this.length_3;
        return perim;
    }

    public static void main(String[] args) {
        
    }
    
}

public class Trio {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Triangle> list_triangle = new ArrayList<>();

        for (int i = 1; i<4; i++){
           System.out.println(" Enter the length of the three sides of triangle number " + i + " : "); 
            System.out.println("Side number 1 ; ");
            int side_1 = scanner.nextInt();
            System.out.println("Side number 2 ; ");
            int side_2 = scanner.nextInt();
            System.out.println("Side number 3 ; ");
            int side_3 = scanner.nextInt();
            list_triangle.add(new Triangle(side_1, side_2, side_3));
        }
    
            Triangle triangle_1 = list_triangle.get(0);
            Triangle triangle_2 = list_triangle.get(1);
            Triangle triangle_3 = list_triangle.get(2);

            System.out.println("The perimeter of the triangle number 1 = " + triangle_1.perimeter());
            System.out.println("The perimeter of the triangle number 2 = " + triangle_2.perimeter());
            System.out.println("The perimeter of the triangle number 3 = " + triangle_3.perimeter());
        scanner.close();
    }
}
