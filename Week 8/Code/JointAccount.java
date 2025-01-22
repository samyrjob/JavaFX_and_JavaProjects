class BankAccount {
    private double balance;
    private int operationCount = 0; // Shared counter for total operations
    private final int MAX_OPERATIONS = 10; // Max allowed operations

    BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized boolean perform(String userName) {
        if (operationCount >= MAX_OPERATIONS) {
            return false; // Stop if max operations reached
        }

        operationCount++; // Increment the shared counter
        int amount = (int)(Math.random() * 100 + 10); // Random amount
        if (Math.random() > 0.5) {
            make_deposit(userName, amount);
        } else {
            withdraw_money(userName, amount);
        }
        return true;
    }

    public synchronized void make_deposit(String userName, double amount) {
        balance += amount;
        System.out.println(userName + " made a deposit of " + amount + " ...........");
        System.out.println(" Now your balance is equal to " + balance);
    }

    public synchronized void withdraw_money(String userName, double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(userName + " has withdrawn " + amount);
            System.out.println("The balance is now : " + balance);
        } else {
            System.out.println(userName + " tried to withdraw " + amount + " but insufficient balance.");
        }
    }

    public synchronized double getBalance() {
        return balance;
    }
}

class UserThread implements Runnable {
    Thread thrd;
    BankAccount account;

    private UserThread(String name, BankAccount account) {
        thrd = new Thread(this, name);
        this.account = account;
    }

    public static UserThread create_and_start(String name, BankAccount account) {
        UserThread userThread = new UserThread(name, account);
        userThread.thrd.start();
        return userThread;
    }

    @Override
    public void run() {
        while (account.perform(thrd.getName())) {
            // Keep performing operations until limit is reached
            try {
                Thread.sleep(100); // Optional delay for better output readability
            } catch (InterruptedException e) {
                System.out.println(thrd.getName() + " interrupted.");
            }
        }
    }
}

public class JointAccount {
    public static void main(String[] args) {
        BankAccount common_bk = new BankAccount(1000);

        UserThread.create_and_start("user1", common_bk);
        UserThread.create_and_start("user2", common_bk);

        System.out.println("All operations completed. Final balance: " + common_bk.getBalance());
    }
}
