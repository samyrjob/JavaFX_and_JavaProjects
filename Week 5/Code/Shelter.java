



class Animal {

    Address address;
    String animal_species;
    String name;

    Animal(Address addr, String animal_s, String n){
        animal_species = animal_s;
        name = n;
        address = addr;

    }

    void displayDetails(){
        System.out.println("This " + animal_species + " is a " + name + " who is sheltered in " + address.city + " in the following address : " + address.street);
    }


}



class Address{
    String street;
    String city;

    Address(String s, String c){
        street = s;
        city = c;
    }

    
}











public class Shelter {

    public static void main(String[] args) {

        Address adresse_animal_ = new Address("Cheney Road 7th door", "Chester");
        Address adresse_anima2_ = new Address("American Street 15th", "Manchester");

        Animal puppy_dog = new Animal(adresse_anima2_, "dog", "Afghan Hound");
        Animal puppy_cat = new Animal(adresse_animal_, "cat", "British shorthair");

        puppy_dog.displayDetails();
        puppy_cat.displayDetails();
        
    }
    
}
