import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

class Cat implements Serializable{

    String name;
    private static final long serialVersionUID = 1L; // Unique identifier
    String breed;
    String description;
    int age;
    static ArrayList<Cat> listOfCats = new ArrayList<>();
    static private String filepath = "catalogcats.ser";
    int id;
    boolean statusAdoption;





    Cat(String n, String b, String d, int a, int i){
        this.id = i;
        this.name = n;
        this.age =a;
        this.description = d;
        this.breed = b;
        this.statusAdoption = false;
    }


    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Setter for breed
    public void setBreed(String breed) {
        this.breed = breed;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // getter for ID 

    public int getID(){
        return this.id;
    }

    public static String getFilePath(){
        return filepath;
    }

    // You may also want to add a method to update the status of adoption if necessary
    public void setStatusAdoption(boolean statusAdoption) {
        this.statusAdoption = statusAdoption;
    }

    private String setStatusAdoptionToString(boolean statusAdoption){
        if (statusAdoption){
            return "Adopted";
        }
        else {
            return "non adopted";
        }

    }


    @SuppressWarnings("unchecked")
    static void displayAvailableCats() throws IOException{

        FileInputStream fileInputStream = new FileInputStream(filepath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        try {
            // Read the object
            Object obj = objectInputStream.readObject();
            if (obj instanceof ArrayList<?>) {
                // Safely cast the object to ArrayList<Cat>
                listOfCats = (ArrayList<Cat>) obj;
            }
        } catch (EOFException e) {
            // End of file reached; this is expected, so no action needed
        } catch (ClassNotFoundException e) {
            // Handle cases where the object type isn't found
            e.printStackTrace();
        } finally {
            // Always close the streams in a 'finally' block
            objectInputStream.close();
            fileInputStream.close();
        }

        


    }

    static void displayListAvailableCats(){
            
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|\n", "ID", "Name", "Age", "Breed", "Description");

        for (Cat cat : listOfCats){
            if (!cat.statusAdoption){
                System.out.printf("|%-10d|%-10s|%-10d|%-10s|%-10s|\n", cat.id, cat.name, cat.age, cat.breed, cat.description);
            }
        }
    }

    

    static void displayAllCatsByStatus() throws IOException{


       
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|\n", "ID", "Name", "Age", "Breed", "Description", "Status");

        for (Cat cat : listOfCats){
           
                System.out.printf("|%-10d|%-10s|%-10d|%-10s|%-10s|%-10s|\n", cat.id, cat.name, cat.age, cat.breed, cat.description, cat.setStatusAdoptionToString(cat.statusAdoption));
            
        }

        


    }


    static void addCatToCatalog() throws IOException{

        FileOutputStream fileOutputStream = new FileOutputStream(filepath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

   
            try{

                objectOutputStream.writeObject(listOfCats);

            }
            catch (IOException e){
                e.printStackTrace();
            }
            finally{
                objectOutputStream.close();
                fileOutputStream.close();
            }
            
    }

    

    
    
    
    
}

public class CatHome {
    
    static Scanner scanner = new Scanner(System.in);

    static void loadDataCats(){

        // Creating cat objects with different breeds
        Cat cat1 = new Cat("Luna", "Siamois", "A sleek, elegant cat with blue eyes.", 3, 1);
        Cat cat2 = new Cat("Oliver", "British Shorthair", "A round-faced cat with a dense, plush coat.", 4, 2);
        Cat cat3 = new Cat("Leo", "Maine Coon", "One of the largest domestic cat breeds, known for its friendly nature.", 5, 3);
        Cat cat4 = new Cat("Bella", "Persan", "A long-haired breed with a cute, flat face.", 2, 4);
        Cat cat5 = new Cat("Milo", "Ragdoll", "A docile and affectionate cat that loves to be cuddled.", 3, 5);
        Cat cat6 = new Cat("Nala", "Sphynx", "A hairless cat breed that loves warmth and attention.", 4, 6);
        Cat cat7 = new Cat("Simba", "Abyssin", "A short-haired breed with a wild look and playful personality.", 2, 7);
        Cat cat8 = new Cat("Chloe", "American Shorthair", "A well-balanced and muscular cat with a friendly temperament.", 6, 8);
        Cat cat9 = new Cat("Lily", "Burmese", "A muscular cat with a short coat and a lovely, sweet voice.", 4, 9);
        Cat cat10 = new Cat("Rocky", "Exotic Shorthair", "A round-faced cat that resembles the Persian, but with a short coat.", 3, 10);
        Cat cat11 = new Cat("Sasha", "Sacré de Birmanie", "A beautiful cat with striking blue eyes and a silky coat.", 2, 11);
        Cat cat12 = new Cat("Oscar", "Scottish Fold", "A cat known for its distinct folded ears and sweet, affectionate personality.", 5, 12);
        
        
       try{
           // Adding cats to catalog
            // Adding cats to listOfCats directly
           Cat.listOfCats.add(cat1);
           Cat.listOfCats.add(cat2);
           Cat.listOfCats.add(cat3);
           Cat.listOfCats.add(cat4);
           Cat.listOfCats.add(cat5);
           Cat.listOfCats.add(cat6);
           Cat.listOfCats.add(cat7);
           Cat.listOfCats.add(cat8);
           Cat.listOfCats.add(cat9);
           Cat.listOfCats.add(cat10);
           Cat.listOfCats.add(cat11);
           Cat.listOfCats.add(cat12);
           Cat.addCatToCatalog();
       } catch(IOException io){
           io.printStackTrace();
       }

    }




    public static void main(String[] args) throws IOException{



        // loadDataCats() if not done ;
        File file = new File(Cat.getFilePath());
        if (file.length() == 0){
            loadDataCats();
        }
        

        Cat.displayAvailableCats();
        showMainMenu();
   


        // function to add cats to the system 


         
    
    
    }

    private static void showMainMenu() throws IOException{
        System.out.println("------MAIN MENU------");
        System.out.println("Are you here to give your cat to our cat shelter or do you want to adopt one ? ");
        System.out.println("1. Add a new Cat ");
        System.out.println("2. Adopt a cat");
        System.out.println("3. Display all cats no matter the status");
        System.out.println("4. Quit the Menu");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addNewCat();
                break;
            case 2:
                adoptACat();
                break;
            case 3:
                Cat.displayAllCatsByStatus();
                showMainMenu();
                break;
            case 4:
                return;
            default:
                showMainMenu();
                break;
        }
        
    }


    private static void addNewCat() throws IOException{


        System.out.println("What is the name of your cat ? ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("What is its age ? ");
        int age = scanner.nextInt();
        System.out.println("What is its breed ? ");
        scanner.nextLine();
        String breed = scanner.nextLine();
        System.out.println("What is its description ? ");
        String description = scanner.nextLine();
        
        Cat.listOfCats.add(new Cat(name, breed, description, age, Cat.listOfCats.size() + 1));
        Cat.addCatToCatalog();
        System.out.println("Congratulations you have added to our shelter your cat ! ");
    
        showMainMenu();
    }


    private static void adoptACat() throws IOException{
        
        // function to adopt a cat 
        System.out.println("1. Choose a cat for adoption from the list");
        System.out.println("2. Or search for a specific cat ");
        System.out.println("3. Come back to the main Menu ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                Cat.displayListAvailableCats();
                System.out.println("press the ID of the cat you want to adopt");
                // implement function of selection of the cat change the status, 
                selectionOfCat(scanner.nextInt());
                break;
            case 2:
               
                System.out.println("Research the cat by breed (press Enter if you have no breed criteria in mind)");
                scanner.nextLine();
                String breed = scanner.nextLine();
                System.out.println("Research the cat by age (Press Enter if you have no age criteria in mind)");
                String ageInput = scanner.nextLine();

                int age = -1;
                if (!ageInput.isEmpty()){

                    try {
                        age = Integer.parseInt(ageInput.trim());
                }
                    catch (NumberFormatException nb){
                        System.out.println("Invalid input for the age of the cat");
                    }
                }
                showFilteredCats(breed, age);
            case 3:
                showMainMenu();
                break; 
            default:
                showMainMenu();
                break;
        }


    }
    
    static void selectionOfCat(int i) throws IOException{

        for (Cat cat : Cat.listOfCats){
            if (i==cat.getID()){
                cat.statusAdoption = true;
                System.out.print("Congratulations you have adopted a new cat ! ");
            }
        }
        Cat.addCatToCatalog();
        showMainMenu();

    }


    static void showFilteredCats(String breed, int age) throws IOException{

        ArrayList<Cat> filteredListCats = new ArrayList<>();

        for (Cat cat : Cat.listOfCats){

            boolean breedBoolean = breed.isEmpty()  || cat.breed.equalsIgnoreCase(breed);
            boolean ageBoolean = (age == -1) || (cat.age == age);
            if (breedBoolean && ageBoolean && !cat.statusAdoption){
                filteredListCats.add(cat);
            }
        }

        if (filteredListCats.isEmpty()){
            System.out.println("Sorry no cat corresponds to your criteria");
            showMainMenu();
        }
        else {
            System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|\n", "ID", "Name", "Age", "Breed", "Description");

            for (Cat cat : filteredListCats){
                    System.out.printf("|%-10d|%-10s|%-10d|%-10s|%-10s|\n", cat.id, cat.name, cat.age, cat.breed, cat.description);
            }
        }
                        
        // display by age the cats otherwise, if no response display all 
        System.out.println("press the ID of the cat you want to adopt");
        selectionOfCat(scanner.nextInt());

    }
    










}