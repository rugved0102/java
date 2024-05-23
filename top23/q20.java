import java.util.*;

interface BankingAccount {
    void deposit(double amount);
    void withdraw(double amount);
    void transfer(BankingAccount toAccount, double amount);
    void viewTransactions();
    String getAccountNumber(); // Added to interface
}

abstract class BankAccount implements BankingAccount {
    protected String accountNumber;
    protected double balance;
    protected List<String> transactions;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: $" + amount);
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew: $" + amount);
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdraw amount or insufficient funds.");
        }
    }

    @Override
    public void transfer(BankingAccount toAccount, double amount) {
        if (toAccount != null && amount > 0 && amount <= balance) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            transactions.add("Transferred: $" + amount + " to " + toAccount.getAccountNumber());
            System.out.println("Transferred: $" + amount + " to " + toAccount.getAccountNumber());
        } else {
            System.out.println("Invalid transfer amount or insufficient funds.");
        }
    }

    @Override
    public void viewTransactions() {
        System.out.println("Transactions for account " + accountNumber + ":");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber) {
        super(accountNumber);
    }
}

class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber) {
        super(accountNumber);
    }
}

public class q20 {
    private static Map<String, BankAccount> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("Welcome to the Banking System");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Checking Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. View Transactions");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    createAccount("Savings");
                    break;
                case 2:
                    createAccount("Checking");
                    break;
                case 3:
                    performDeposit();
                    break;
                case 4:
                    performWithdraw();
                    break;
                case 5:
                    performTransfer();
                    break;
                case 6:
                    viewTransactions();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void createAccount(String type) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account;
        if (type.equals("Savings")) {
            account = new SavingsAccount(accountNumber);
        } else {
            account = new CheckingAccount(accountNumber);
        }
        accounts.put(accountNumber, account);
        System.out.println(type + " account created with account number: " + accountNumber);
    }

    private static void performDeposit() {
        BankAccount account = getAccount();
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        }
    }

    private static void performWithdraw() {
        BankAccount account = getAccount();
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        }
    }

    private static void performTransfer() {
        System.out.print("Enter your account number: ");
        String fromAccountNumber = scanner.nextLine();
        BankAccount fromAccount = accounts.get(fromAccountNumber);
        if (fromAccount != null) {
            System.out.print("Enter recipient's account number: ");
            String toAccountNumber = scanner.nextLine();
            BankAccount toAccount = accounts.get(toAccountNumber);
            if (toAccount != null) {
                System.out.print("Enter amount to transfer: ");
                double amount = scanner.nextDouble();
                fromAccount.transfer(toAccount, amount);
            } else {
                System.out.println("Recipient account not found.");
            }
        } else {
            System.out.println("Your account not found.");
        }
    }

    private static void viewTransactions() {
        BankAccount account = getAccount();
        if (account != null) {
            account.viewTransactions();
        }
    }

    private static BankAccount getAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
        }
        return account;
    }
}
