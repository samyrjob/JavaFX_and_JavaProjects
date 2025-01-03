import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many \u00A310 notes do you have?\t");
        byte ten = scanner.nextByte();
        //scanner.nextLine();
        System.out.print("\n How many \u00A320 notes do you have?\t");
        byte twenty = scanner.nextByte();
        //scanner.nextLine();
        System.out.print("\n How many \u00A350 notes do you have?\t");
        byte fifty = scanner.nextByte();
        scanner.nextLine();
        int total = 10*ten + 20*twenty + 50*fifty;
        System.out.print("------- \n In total you have " +  (ten+twenty+fifty) +" notes and a total amount of \u00A3" + total + ".\n" );
        System.out.println("\t\u00A310\tQty:" + ten + "\t(Value " + "\u00A3" + 10*ten + ")");
        System.out.println("\t\u00A320\tQty:" + twenty + "\t(Value " + "\u00A3" + 20*twenty + ")");
        System.out.println("\t\u00A350\tQty:" + fifty + "\t(Value " + "\u00A3" + 50*fifty + ")");

        scanner.close();
    }
    
}
