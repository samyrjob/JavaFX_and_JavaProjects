public class MyAnimal implements Rabbit , Pet, Creature{

    public void sleep(){

        System.out.println("zzzzzzzzzzzz");
    }

    public void stroke(){

        System.out.println("strooooooooke");
    }

    public void eat(){

        System.out.println("cruch cruch cruch");
    }

    public static void main(String[] args) {
        MyAnimal myanimal  = new MyAnimal();
        myanimal.sleep();
        myanimal.stroke();
        myanimal.eat();
    }
    
}
