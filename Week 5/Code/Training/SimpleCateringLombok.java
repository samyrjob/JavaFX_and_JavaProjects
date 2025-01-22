import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

abstract class Product {

    private String name;
    private double price;
    private double calories;
    private int quantity;

    // Abstract methods
    abstract void displayDetails();
}

class Drink extends Product {

    public Drink(String name, double price, double calories, int quantity) {
        super(name, price, calories, quantity);
    }

    @Override
    void displayDetails() {
        System.out.println(" Name of the Drink: " + getName() + 
                           " Price: " + getPrice() + "£" + 
                           " Calories: " + getCalories() + " kcal" + 
                           " Quantity: " + getQuantity());
    }
}

class Snack extends Product {

    public Snack(String name, double price, double calories, int quantity) {
        super(name, price, calories, quantity);
    }

    @Override
    void displayDetails() {
        System.out.println(" Name of the Snack: " + getName() + 
                           " Price: " + getPrice() + "£" + 
                           " Calories: " + getCalories() + " kcal" + 
                           " Quantity: " + getQuantity());
    }
}

class Sandwich extends Product {

    public Sandwich(String name, double price, double calories, int quantity) {
        super(name, price, calories, quantity);
    }

    @Override
    void displayDetails() {
        System.out.println(" Name of the Sandwich: " + getName() + 
                           " Price: " + getPrice() + "£" + 
                           " Calories: " + getCalories() + " kcal" + 
                           " Quantity: " + getQuantity());
    }
}

public class SimpleCateringLombok {

    public static void main(String[] args) {
        Drink drink = new Drink("Energy Drink", 1.9, 500, 90);
        Snack snack = new Snack("Mars", 2.5, 780, 80);
        Sandwich sandwich = new Sandwich("Tuna Sandwich", 3.9, 1000, 15);

        // Display full details
        drink.displayDetails();
        snack.displayDetails();
        sandwich.displayDetails();

        // Modify and redisplay drink details
        drink.setName("Vodka 1.5 L");
        drink.setPrice(11.5);
        drink.setCalories(950);
        drink.setQuantity(56);
        drink.displayDetails();
    }
}
