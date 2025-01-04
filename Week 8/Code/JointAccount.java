import java.util.Scanner;



class BankAccount {

    double balance;

    BankAccount(double balance){
        this.balance = balance;
    }


    synchronized void make_deposit(double deposit){

        balance += deposit;
        if (balance < 0 ){
            System.out.println("the balance is still bellow zero , you still have to add " + (-balance) + " to cover the bank account in the green");
    } else {
        System.out.println("you made a deposit of "+ deposit + " ...........\n Now your balance is equal to " + balance);
    }
}

    synchronized void withdraw_money(double withdraw){
        balance -= withdraw;
        if (balance < 0){
            System.out.println("You have withdrawn " + withdraw);
            System.out.println("the balance fell bellow zero, the balance is indeed : " + balance);
        } else {
            System.out.println("You have withdrawn " + withdraw);
            System.out.println("The balance is now : " + balance);
        }


    }


}


class UserThread implements Runnable {

    Scanner scanner = new Scanner(System.in);
    Thread thrd;
    BankAccount bankaccount;
    static final Object lock = new Object(); // Shared lock for synchronization

    UserThread(BankAccount bk, String name){
        thrd = new Thread(this, name);
        bankaccount = bk;
    }

    public static UserThread start_and_create(String name, BankAccount bk){
        UserThread userthread = new UserThread(bk, name);
        userthread.thrd.start();
        return userthread;
    }

    public void run(){


        try {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    System.out.println("\n" + thrd.getName() + ", choose an option:");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1 -> {
                            System.out.print(thrd.getName() + ", enter deposit amount: ");
                            double deposit = scanner.nextDouble();
                            bankaccount.make_deposit(deposit);
                            System.out.println(thrd.getName() + "'s operation completed.");
                        }
                        case 2 -> {
                            System.out.print(thrd.getName() + ", enter withdrawal amount: ");
                            double withdraw = scanner.nextDouble();
                            bankaccount.withdraw_money(withdraw);
                            System.out.println(thrd.getName() + "'s operation completed.");
                        }
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                   
                }
            }

        }
        catch (Exception ie){
            ie.printStackTrace();

        }
    }
}



public class JointAccount {

    public static void main(String[] args) {

        BankAccount common_bk = new  BankAccount(1000);
        
        UserThread user1 = UserThread.start_and_create("user1", common_bk);
        UserThread user2 = UserThread.start_and_create("user2", common_bk);


        try {
            user1.thrd.join();
            user2.thrd.join();
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }

        System.out.println("\nAll operations completed. Final balance: " + common_bk.balance);

    }





}