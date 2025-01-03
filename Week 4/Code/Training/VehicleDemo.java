package Training;

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle minivan = new Vehicle();
        int range;


        // Assignment of values :
        minivan.passengers = 7;
        minivan.fuelcap = 16;
        minivan.mpg = 21;

        range = minivan.fuelcap * minivan.mpg;
        System.out.println(" Minivan can carry " + minivan.passengers + " With a range of " + range);
    }
  
    
}
