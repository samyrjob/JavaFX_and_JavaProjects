import java.util.Scanner;

public class IntAdder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two integers");
        int a = input.nextInt();
        int b = input.nextInt();
        input.close();
        System.out.println("Answer: "+add(a,b));
    }    

    static int add(int x, int y) {
        return x+y;
    }
}
