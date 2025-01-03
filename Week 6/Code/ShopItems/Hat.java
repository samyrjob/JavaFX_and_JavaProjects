package ShopItems;


abstract class Clothes {

    abstract String return_attribute();

}


public class Hat extends Clothes {

    private String color = " red ";


    @Override
    public String return_attribute() {
        
        return color;
    }



}
