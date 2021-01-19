package tut11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Task 2 - asynchronous, there is a huge chance that the end value will not be correct, and will change each run
        Account account = new Account(1000);
        System.out.println("initial account value: " + account.toString());

        new Thread(ones(account)).start();
        new Thread(random(account)).start();
        new Thread(deposit(account)).start();
        new Thread(withdraw(account)).start();
        TimeUnit.MILLISECONDS.sleep(1000); //to make sure tasks are finished
        System.out.println("Final account value (should be 1000): " + account);


        //Task 3 - synchronized, the final value should be always 1000
        account  = new AccountSynchronized(1000);
        new Thread(ones(account)).start();
        new Thread(random(account)).start();
        new Thread(deposit(account)).start();
        new Thread(withdraw(account)).start();
        TimeUnit.MILLISECONDS.sleep(1000); //to make sure tasks are finished
        System.out.println("Final account (synchronized) value (should be 1000): " + account);

        //Task 5
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            for(int i = 0; i < 30; i++)
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    static Runnable random(Account account)
    {
        return () -> {
            for(int i = 0; i < 10000; i++)
            {
                account.withdraw(100);
                account.withdraw(200);
                account.deposit(400);
                account.withdraw(100);
            }
        System.out.println("random");
    };
    }

    static Runnable deposit(Account account)
    {
        return () -> {
            for(int i = 0; i < 10000; i++)
            {
            account.deposit(10);     //10
            account.deposit(30);     //40
            account.deposit(40);     //80
            account.deposit(30);     //110
            account.deposit(100);    //210
            account.deposit(130);    //340
            account.deposit(170);    //510
            account.deposit(100);    //610
            }
            System.out.println("income");
        };
    }

    static Runnable withdraw(Account account)
    {
        return () -> {
            for(int i = 0; i < 10000; i++)
            {
            account.withdraw(30);   //30
            account.withdraw(20);   //50
            account.withdraw(49);   //99
            account.withdraw(1);    //100
            account.withdraw(200);  //300
            account.withdraw(177);  //477
            account.withdraw(33);   //510
            account.withdraw(100);  //610
            }
            System.out.println("withdraw");
        };
    }

    static Runnable ones(Account account)
    {
        return () -> {
            for (int i = 0; i < 10000; i++) {
                account.withdraw(1);
                account.deposit(1);
            }
            System.out.println("ones");
        };
    }
}
