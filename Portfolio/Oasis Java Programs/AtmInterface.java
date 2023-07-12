import java.util.Scanner;

public class AtmInterface {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Account account = new Account();
            System.out.println("Welcome to the ATM");

            // Prompt user for ID and PIN
            System.out.print("Enter your ID: ");
            int id = scanner.nextInt();
            System.out.print("Enter your PIN: ");
            int pin = scanner.nextInt();

            // Check if ID and PIN match
            if (account.login(id, pin)) {
                System.out.println("Access granted. What would you like to do?");

                boolean quit = false;
                while (!quit) {
                    System.out.println("1. Transactions History");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Transfer");
                    System.out.println("5. Quit");

                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            account.transactionsHistory();
                            break;
                        case 2:
                            System.out.print("Enter the amount to withdraw: ");
                            double withdrawAmount = scanner.nextDouble();
                            account.withdraw(withdrawAmount);
                            break;
                        case 3:
                            System.out.print("Enter the amount to deposit: ");
                            double depositAmount = scanner.nextDouble();
                            account.deposit(depositAmount);
                            break;
                        case 4:
                            System.out.print("Enter the account number to transfer to: ");
                            int transferAccount = scanner.nextInt();
                            System.out.print("Enter the amount to transfer: ");
                            double transferAmount = scanner.nextDouble();
                            account.transfer(transferAccount, transferAmount);
                            break;
                        case 5:
                            quit = true;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                }
            } else {
                System.out.println("Access denied. Incorrect ID or PIN.");
            }
        }
    }
}

class Account {
    private int id;
    private int pin;
    private double balance;
    private double transactionsHistory;

    public Account() {
        this.id = 1234;
        this.pin = 2131;
        this.balance = 1000.00;
    }

    public boolean login(int id, int pin) {
        if (this.id == id && this.pin == pin) {
            return true;
        } else {
            return false;
        }
    }

    public void transactionsHistory() {
        System.out.println("Your transaction history is: " + this.transactionsHistory);
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient funds.");
        } else {
            this.balance -= amount;
            this.transactionsHistory += amount;
            System.out.println("Successful withdrawal. Your new balance is: " + this.balance);
        }
    }

    public void deposit(double amount) {
        this.balance += amount;
        this.transactionsHistory -= amount;
        System.out.println("Successful deposit. Your new balance is: " + this.balance);
    }
    public void transfer(int accountNumber, double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient funds.");
        } else {
            this.balance -= amount;
            this.transactionsHistory += amount;
            System.out.println("Successful transfer of $" + amount + " to account number " + accountNumber + ". Your new balance is: " + this.balance);
        }
    }
}
