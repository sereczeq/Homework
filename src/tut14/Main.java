package tut14;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        //Task 1
        System.out.println("Task 1");
        Account james = new Account("James");
        Account mark = new Account("Mark");
        Observable.just(100, -200, 3000, 400, -2500).subscribe((amount) -> System.out.println(james.operation(amount) + mark.getBalance()));
        Observable.just(12, -3000, 455, 712, 670).subscribe((amount) -> System.out.println(james.getBalance() + mark.operation(amount)));
        //Task 2
        System.out.println("Task 2");
        james.setBalance(0);
        mark.setBalance(0);
        Observable.just(100, -200, 3000, 400, -2500).subscribe((amount) -> System.out.println(james.setBalance(amount) + mark.getBalance()));
        Observable.just(12, -3000, 455, 712, 670).subscribe((amount) -> System.out.println(james.getBalance() + mark.setBalance(amount)));
        //Task 3
        System.out.println("Task 3");
        final int howManyTimes = 10;
        final int period = 2;
        Observable.intervalRange(1, howManyTimes, 0, period, TimeUnit.SECONDS).take(howManyTimes)
                .scan((x, y) -> x * y).subscribe(System.out::println);
        try {
            TimeUnit.SECONDS.sleep(howManyTimes * period);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
