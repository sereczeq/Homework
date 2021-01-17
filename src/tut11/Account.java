package tut11;

public class Account {
    private int balance;

    public Account()
    {
        this.balance = 0;
    }

    public Account(int balance) {
        this.balance = balance;
    }

    public int withdraw(int amount)
    {
        return this.balance -= amount;
    }

    public int income(int amount)
    {
        return this.balance += amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
