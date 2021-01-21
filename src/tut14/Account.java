package tut14;

public class Account {
    private int balance;
    private final String name;

    public Account(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public Account(String name) {
        this.balance = 0;
        this.name = name;
    }

    public int operation(int amount)
    {
        return balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public int setBalance(int balance) {
        return this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name +
                ", balance=" + balance + '\'' +
                '}';
    }
}
