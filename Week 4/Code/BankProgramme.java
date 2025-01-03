import java.util.Scanner;

class BankAccount {

    String name;
    double balance;

void deposit_money(double add_money){
    this.balance += add_money;

}

void withdraw_money(double withdraw_money){
    this.balance -= withdraw_money;

}
void display_balance(){
    System.out.println( "Your actual balance is " + this.balance + " \u00A3");
}
    
}


public class BankProgramme{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bankaccount = new BankAccount();
        bankaccount.name = "Samy";
        bankaccount.balance = 0;
        boolean exit = false;
        int choice;
        System.out.println("Welcome to your bank account "+ bankaccount.name);
        do{
            System.out.println("--------------------------\n\n 1. Press 1 to deposit money\n 2. Press 2 to withdraw money\n 3. Press 3 to display the balance\n 4. Press 4 to exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Insert the amount you wish to deposit");
                    double deposit_amount = scanner.nextDouble();
                    if (deposit_amount > 0){
                        System.out.println("You just have made a deposit of " + deposit_amount);
                        bankaccount.balance += deposit_amount;   
                    }
                    else {
                        System.out.println("Sorry it should be a value strictly positive !");
                    }
                    break;
                case 2:
                    System.out.println("Insert the amount you wish to withdraw ?");
                    double withdraw_amount = scanner.nextDouble();

                    if(bankaccount.balance>= withdraw_amount && withdraw_amount > 0){
                        bankaccount.withdraw_money(withdraw_amount);
                        System.out.println("You have withdrawn " + withdraw_amount + "\u00A3");
                    }
                    else if (bankaccount.balance < withdraw_amount ) {
                        System.out.println("Sorry you don't have enough funds");

                    }
                    else {
                        System.out.println("Negative value... Impossible to perform any action");
                    }
                    break;
                case 3:
                    bankaccount.display_balance();
                    break;
                    
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("keytab not recognized.\n\n");
                    
                    
            }
        } while (exit ==false);

        scanner.close();
    }


}