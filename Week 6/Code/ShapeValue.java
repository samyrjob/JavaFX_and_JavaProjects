
class Rectangle implements Shapes {
    private double width;
    private double length;

    Rectangle(double w, double l){
        width =w;
        length = l;
    }

    public void calculateArea(){
        System.out.println("the area of a rectangle is l*L which is equal to : " + (width*length));
    }

    public void calculatePerimeter(){
        System.out.println("The perimeter of a rectangle is l*2 + L*2 which is equal to :" + (length*2 + width*2));
    }
    
}


class Circle implements Shapes{

    private double ray;

    Circle(double r){
        this.ray = r;
    }

    public void calculateArea(){
        System.out.println("the area of the circle is l*L which is equal to : " + (PIE*(Math.pow(ray,2))));
    }

    public void calculatePerimeter(){
        System.out.println("The perimeter of the circle is 2*PIE*r which is equal to :" + (ray*2*PIE));
    }
    
}




public class ShapeValue {

    public static void main(String[] args) {
        Circle circle = new Circle(10);
        Rectangle rectangle = new Rectangle(5,3);
        circle.calculateArea();
        circle.calculatePerimeter();
        rectangle.calculateArea();
        rectangle.calculatePerimeter();

    }
    
}
