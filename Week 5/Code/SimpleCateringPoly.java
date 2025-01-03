abstract class ProductPoly {

    String name;
    double price;
    double calories;
    int quantity;


    ProductPoly(String n, double p, double c, int q){
        name = n;
        price = p;
        calories = c;
        quantity = q;

    }

    void consume(){
        System.out.println("Try the sound for each product your consume with consume method ! ");
    }


    abstract void displayDetails();

    abstract void displayName();
    abstract void displayPrice();
    abstract void displayCalories();
    abstract void displayQuantity();

    
    abstract void setName(String n);
    abstract void setPrice(double p);
    abstract void setCalories(double c);
    abstract void setQuantity(int q);



}


class DrinkPoly extends ProductPoly {

    DrinkPoly(String n, double p, double c, int q){
        super(n, p, c, q);
    }

    void displayDetails(){
        System.out.println(" Name of the DrinkPoly : " + this.name + " Price : " + this.price + "\u00A3  " + " Number of calories : " + this.calories + " Kcal" + " Quantity : "+ this.quantity );
    }


   // getters 
    void displayName(){

        System.out.println("The name of this drinkPoly is " + name);

    }
    void displayPrice(){
         System.out.println("The price of one " + name + " is " + price + "\u00A3");

    }
    void displayCalories(){
         System.out.println("The calories for one  " + name + " are " + calories + " kcal");

    }
    void displayQuantity(){
         System.out.println("There are " + quantity + " " + name + " left in stock");

    }

    // setters 
    void setName(String n){
        this.name = n;

    }
    void setPrice(double p){
        this.price = p;

    }
    void setCalories(double c){
        this.calories = c;

    }
    void setQuantity(int q){
        this.quantity = q;

    }

    void consume(){
        System.out.println("Glug, glug, glug.");
    }




}

class SnackPoly extends ProductPoly {

      SnackPoly(String n, double p, double c, int q){
        super(n, p, c, q);
    }


     void displayDetails(){
        System.out.println(" Name of the SnackPoly : " + this.name + " Price : " + this.price + "\u00A3  " + " Number of calories : " + this.calories + " Kcal"+" Quantity : "+ this.quantity );
    }
      // getters 
    void displayName(){

        System.out.println("The name of this snackPoly is " + name);

    }
    void displayPrice(){
         System.out.println("The price of one " + name + " is " + price + "\u00A3");

    }
    void displayCalories(){
        System.out.println("The calories for one  " + name + " are " + calories + " kcal");


    }
    void displayQuantity(){
         System.out.println("There are " + quantity + " " + name + " left in stock");

    }

    // setters
    void setName(String n){
        this.name = n;

    }
    void setPrice(double p){
        this.price = p;

    }
    void setCalories(double c){
        this.calories = c;

    }
    void setQuantity(int q){
        this.quantity = q;

    }

    void consume(){
        System.out.println("Crunch, Crunch");
    }


}



class SandwichPoly extends ProductPoly {

      SandwichPoly(String n, double p, double c, int q){
        super(n, p, c, q);
    }


     void displayDetails(){
        System.out.println(" Name of the SandwichPoly : " + this.name + " Price : " + this.price + "\u00A3  "+ " Number of calories : " + this.calories + " Kcal"+ " Quantity : "+ this.quantity );
    }

  // getters 
    void displayName(){

        System.out.println("The name of this sandwichPoly is " + name);

    }
    void displayPrice(){
        System.out.println("The price of one " + name + " is " + price + "\u00A3");

    }
    void displayCalories(){
        System.out.println("The calories for one  " + name + " are " + calories + "kcal");


    }
    void displayQuantity(){
            System.out.println("There are " + quantity + " " + name +  " left in stock");


    }

    // setters

    void setName(String n){
        this.name = n;

    }
    void setPrice(double p){
        this.price = p;

    }
    void setCalories(double c){
        this.calories = c;

    }
    void setQuantity(int q){
        this.quantity = q;

    }

    void consume(){
        System.out.println("Chomp !");
    }



}




public class SimpleCateringPoly {
    
    public static void main(String [] args ){

        DrinkPoly drinkPoly = new DrinkPoly("Energy DrinkPoly", 1.9, 500, 90);
        SnackPoly snackPoly = new SnackPoly("Mars", 2.5, 780, 80);
        SandwichPoly sandwichPoly = new SandwichPoly("tuna sandwichPoly", 3.9, 1000, 15);

        // display full details
        drinkPoly.displayDetails();
        sandwichPoly.displayDetails();
        snackPoly.displayDetails();

        // display names : 

        drinkPoly.displayName();
    

        // display prices : 

        drinkPoly.displayPrice();
      

        // display calories

        drinkPoly.displayCalories();
     

        // display quantity 

        drinkPoly.displayQuantity();

        drinkPoly.setName("Vodka 1.5 L");
        drinkPoly.setPrice(11.5);
        drinkPoly.setCalories(950);
        drinkPoly.setQuantity(56);

        drinkPoly.displayDetails();

        drinkPoly.consume();
        sandwichPoly.consume();
        snackPoly.consume();

    }

}