public class BankAccount {
    String holderName;
    double balance;

    public BankAccount(String name) {
        holderName = name;
    }

    public BankAccount(String name, double init) {
        holderName = name;
        balance = init;
    }

    public void deposit(double val) {
        balance += val;
    }

    public void withdraw(double val) {
        balance -= val;
    }

    public double getBalance() {
        return balance;
    }
}
