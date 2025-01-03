
import java.util.Scanner;
public class PassCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter password:");
        String pwd = input.nextLine();
        input.close();
        System.out.println(checkPass(pwd));
    }
    static boolean checkPass(String p) {
        if (p.equalsIgnoreCase("Java")) {
            return true;
        }
        else {
            return false;
        }
    }
}