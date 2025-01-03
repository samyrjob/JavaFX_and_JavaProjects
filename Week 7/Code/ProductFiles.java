import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


class Product implements Serializable {
    public static final long serialVersionUID = 1L;
    String name;
    double price;
    double calories;
    int quantities;

    Product(String n, double p, double c, int q){
        this.name = n;
        this.price = p;
        this.calories = c;
        this.quantities = q;
    }

    String display_details(){
        return "Name : " + this.name + "\t" + "Price : " + this.price + "\u00A3\t" + "Calories :" + this.calories + " Kcal\t" + "Quantity : " + this.quantities;
    }

    void add_product_to_serialized(ArrayList<Product> arraylist_products, File file){

        try (FileOutputStream fileOutputStream = new FileOutputStream(file.getName()); ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);){

            boolean productExists = false;
            for (Product product : arraylist_products) {
                if (this.name.equals(product.name)) {
                    productExists = true;
                    break;
                }
            }
            if (productExists == false){
                arraylist_products.add(this);
                objectOutputStream.writeObject(arraylist_products);
                System.out.println("the product object has been serialized");
            }

            
        }
        catch (IOException ea){
            ea.printStackTrace();
        }
    }

    void read_product_from_serialized_file(File file){
        boolean not_present = false;
        try (FileInputStream fileInputStream = new FileInputStream(file.getName()); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);){

            ArrayList <Product> list_products_deserialized = (ArrayList <Product>) objectInputStream.readObject();
            for (Product product : list_products_deserialized){
                if (this.name.equals(product.name)){
                    System.out.println(product.display_details());
                }
                else {
                    // if not present in the arraylist of products so I add it then I read it
                    not_present = true;
                    System.out.println("The object has not been found in the serialized file but no worries you can still read it and after this it will be serialized into it : ");
                    this.display_details();
                }
            }
            if (not_present){
                add_product_to_serialized(list_products_deserialized, file);
            }
         }
         catch (IOException | ClassNotFoundException ea){
             ea.printStackTrace();
         }

    }
    
    static void remove_product_from_serialized_file(String choice, ArrayList<Product> arraylist_products, String filename) {
        // Step 1: Read existing products
        // try (FileInputStream fileInputStream = new FileInputStream(filename);
        //      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
    
        //     arraylist_products = (ArrayList<Product>) objectInputStream.readObject();
    
        // } catch (EOFException e) {
        //     System.out.println("The file is empty or corrupted. No products to remove.");
        //     return; // Exit early if the file is empty
        // } catch (IOException | ClassNotFoundException e) {
        //     e.printStackTrace();
        //     return;
        // }
    
        // Step 2: Remove the specified product
        boolean productRemoved = arraylist_products.removeIf(product -> product.name.equals(choice));
        if (!productRemoved) {
            System.out.println("Product not found in the list.");
            return;
        }
    
        // Step 3: Write updated list back to the file
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
    
            objectOutputStream.writeObject(arraylist_products);
            System.out.println("The product has been successfully removed from the serialized file.");
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    


    
}

public class ProductFiles {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList <Product> list_of_products = new ArrayList<>();
    static String filename;

    static void add_and_read_product_from_to_serialized_file(String filename, Product product){
        
        try {
            File file = new File(filename);
            if (file.createNewFile()){
                System.out.println("the file " + file.getName() + "has been successfully created");
                System.out.println("process to add the product object into the serialized file " + file.getName());
                product.add_product_to_serialized(list_of_products, file);
                System.out.println("process to read the product object from the serialized file " + file.getName());
                product.read_product_from_serialized_file(file);
            }
            else {
                System.out.println("the file already exists BUT HERE WE GO : ");
                System.out.println("process to add the product object into the serialized file " + file.getName());
                product.add_product_to_serialized(list_of_products, file);
                System.out.println("process to read the product object from the serialized file " + file.getName());
                product.read_product_from_serialized_file(file);
            }

        }
        catch (IOException eo){
            eo.printStackTrace();

        }
    }

    static void load_arraylist_from_serializedfile_to_localprogramme(String filename){

        try (FileInputStream fileInputStream = new FileInputStream(filename); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);){
           list_of_products = (ArrayList <Product>) objectInputStream.readObject();
                }
        catch (EOFException e) {
                    // Handle empty file gracefully
                    System.out.println("The file is empty.");
                } 
        catch(IOException | ClassNotFoundException eo){
            eo.printStackTrace();
        }
    }


    public static void main(String[] args) {


        filename = "list_of_serialized_products.dat";
        load_arraylist_from_serializedfile_to_localprogramme(filename);
    
        System.out.println(list_of_products.size());
        Product product = new Product("Kinder Bueno", 5.5, 369, 50);
        add_and_read_product_from_to_serialized_file(filename, product);
        int input_pressed;
        do {
            System.out.println("\n Press 1 t add a new product in the serialized file \n Press 2 to remove a product from the serialized file\n Press 3 to exit the programme");
            input_pressed = scanner.nextInt();
            switch(input_pressed){
                case 1:
                    scanner.nextLine();
                    System.out.println("What is the name of the product");
                    String product_name = scanner.nextLine();
                    System.out.println("Price : ");
                    double product_price = (double) scanner.nextDouble();
                    System.out.println("Number of Calories: ");
                    double product_cal = (double) scanner.nextDouble();
                    System.out.println("Quantity in stock : ");
                    int product_qty = scanner.nextInt();
                    Product new_product = new Product(product_name, product_price, product_cal, product_qty);
                    add_and_read_product_from_to_serialized_file(filename, new_product);
                    break;
                case 2:
                    for (Product product_in_list : list_of_products){
                        System.out.println(product_in_list.name);
                    }
                    System.out.println("which product from the above list you want to remove from the serialized file ? ");
                    scanner.nextLine();
                    String choice = scanner.nextLine();
                    Product.remove_product_from_serialized_file(choice, list_of_products, filename);
                    break;
                case 3:
                    System.out.println("exiting the programme");
                    break;
                default:
                    System.out.println("invalid input, please try again to choose an option");

                
    
    
            }
        } while (input_pressed != 3);

        
    }
    
}
