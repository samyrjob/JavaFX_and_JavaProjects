


abstract class Product {

    String name;
    double price;
    double calories;
    int quantity;


    Product(String n, double p, double c, int q){
        name = n;
        price = p;
        calories = c;
        quantity = q;

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


class Drink extends Product {

    Drink(String n, double p, double c, int q){
        super(n, p, c, q);
    }

    void displayDetails(){
        System.out.println(" Name of the Drink : " + this.name + " Price : " + this.price + "\u00A3  " + " Number of calories : " + this.calories + " Kcal" + " Quantity : "+ this.quantity );
    }


   // getters 
    void displayName(){

        System.out.println("The name of this drink is " + name);

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




}

class Snack extends Product {

      Snack(String n, double p, double c, int q){
        super(n, p, c, q);
    }


     void displayDetails(){
        System.out.println(" Name of the Snack : " + this.name + " Price : " + this.price + "\u00A3  " + " Number of calories : " + this.calories + " Kcal"+" Quantity : "+ this.quantity );
    }
      // getters 
    void displayName(){

        System.out.println("The name of this snack is " + name);

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




}



class Sandwich extends Product {

      Sandwich(String n, double p, double c, int q){
        super(n, p, c, q);
    }


     void displayDetails(){
        System.out.println(" Name of the Sandwich : " + this.name + " Price : " + this.price + "\u00A3  "+ " Number of calories : " + this.calories + " Kcal"+ " Quantity : "+ this.quantity );
    }

  // getters 
    void displayName(){

        System.out.println("The name of this sandwich is " + name);

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



}




public class SimpleCatering {
    
    public static void main(String [] args ){

        Drink drink = new Drink("Energy Drink", 1.9, 500, 90);
        Snack snack = new Snack("Mars", 2.5, 780, 80);
        Sandwich sandwich = new Sandwich("tuna sandwich", 3.9, 1000, 15);

        // display full details
        drink.displayDetails();
        sandwich.displayDetails();
        snack.displayDetails();

        // display names : 

        drink.displayName();
    

        // display prices : 

        drink.displayPrice();
      

        // display calories

        drink.displayCalories();
     

        // display quantity 

        drink.displayQuantity();

        drink.setName("Vodka 1.5 L");
        drink.setPrice(11.5);
        drink.setCalories(950);
        drink.setQuantity(56);

        drink.displayDetails();
    }

}