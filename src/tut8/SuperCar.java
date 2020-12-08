package tut8;

public class SuperCar extends Car {
    public SuperCar()
    {
        price = 100_000_000;
        doors = 2;
        engineType = 12;
        zeroToHundred = 8;
        numberOfGears = 6;
    }

    @Override
    public void slowDown() {
        currentVelocity -= 30;
    }

    @Override
    public void drift() {
        System.out.println("looks to expensive to do that");
    }
}
