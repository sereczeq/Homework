package tut11;

public class AccountSynchronized extends Account {
    public AccountSynchronized() {
        super();
    }

    public AccountSynchronized(int balance) {
        super(balance);
    }

    @Override
    public synchronized int deposit(int amount) {
        return super.deposit(amount);
    }

    @Override
    public synchronized int withdraw(int amount) {
        return super.withdraw(amount);
    }
}
