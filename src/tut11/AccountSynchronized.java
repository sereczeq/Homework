package tut11;

public class AccountSynchronized extends Account {
    public AccountSynchronized() {
        super();
    }

    public AccountSynchronized(int balance) {
        super(balance);
    }

    @Override
    public synchronized int income(int amount) {
        return super.income(amount);
    }

    @Override
    public synchronized int withdraw(int amount) {
        return super.withdraw(amount);
    }
}
