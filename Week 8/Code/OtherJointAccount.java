import java.util.Scanner;

class BankAccount {
    public double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void makeDeposit(double deposit) {
        balance += deposit;
        System.out.println("Deposit of " + deposit + " made successfully.");
        System.out.println("New balance: " + balance);
    }

    void withdrawMoney(double withdraw) {
        balance -= withdraw;
        if (balance < 0) {
            System.out.println("Withdrawal of " + withdraw + " made.");
            System.out.println("Balance fell below zero. Current balance: " + balance);
        } else {
            System.out.println("Withdrawal of " + withdraw + " made successfully.");
            System.out.println("New balance: " + balance);
        }
    }
}

class UserThread implements Runnable {
    private static final Object lock = new Object(); // Shared lock for thread synchronization
    private final Thread thread;
    private final BankAccount bankAccount;
    private final Scanner scanner = new Scanner(System.in);

    UserThread(BankAccount bankAccount, String name) {
        this.bankAccount = bankAccount;
        this.thread = new Thread(this, name);
    }

    public static UserThread startAndCreate(String name, BankAccount bankAccount) {
        UserThread userThread = new UserThread(bankAccount, name);
        userThread.thread.start();
        return userThread;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    System.out.println("\n" + thread.getName() + ", choose an option:");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1 -> {
                            System.out.print(thread.getName() + ", enter deposit amount: ");
                            double deposit = scanner.nextDouble();
                            bankAccount.makeDeposit(deposit);
                        }
                        case 2 -> {
                            System.out.print(thread.getName() + ", enter withdrawal amount: ");
                            double withdraw = scanner.nextDouble();
                            bankAccount.withdrawMoney(withdraw);
                        }
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                    System.out.println(thread.getName() + "'s operation completed.");
                }
            }
        } catch (Exception e) {
            System.out.println(thread.getName() + " encountered an error: " + e.getMessage());
        }
    }

    public void join() throws InterruptedException {
        thread.join();
    }
}

public class OtherJointAccount {
    public static void main(String[] args) {
        BankAccount commonBankAccount = new BankAccount(1000);

        UserThread user1 = UserThread.startAndCreate("User1", commonBankAccount);
        UserThread user2 = UserThread.startAndCreate("User2", commonBankAccount);

        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nAll operations completed. Final balance: " + commonBankAccount.balance);
    }
}
