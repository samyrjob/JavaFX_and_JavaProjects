
class Fruit {

    void taste(){
        System.out.println("Let's try fruit's taaste !!");

    }


}

class Apple extends Fruit {

    void taste(){
        System.out.println("The taste of an apple is very sweeeeeeeet");
    }
    
}

class Lemon extends Fruit {

    void taste(){
        System.out.println("The taste of a lemon is very acid");
    }

    
}

class Orange extends Fruit {

    void taste(){
        System.out.println("The taste of an orange is even sweeter than apple");
    }

    
}



public class Taste {
    
    public static void main(String[] args) {
    
        Orange orangina = new Orange();
        Lemon lemona = new Lemon();
        Apple apple = new Apple();
        apple.taste();
        lemona.taste();
        orangina.taste();
        
    }



    
}
