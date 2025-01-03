import ShopItems.*;

class TestShop {

    public static void main(String[] args) {
        Hat hat = new Hat();
        Jeans jeans = new Jeans();
        Tshirt tshirt = new Tshirt();
    
        System.out.println("The color of the hat is " + hat.return_attribute());
        System.out.println("The size of the jeans is " + jeans.return_attribute());
        System.out.println("The brand of the tshirt is " + tshirt.return_attribute());
    }
}
