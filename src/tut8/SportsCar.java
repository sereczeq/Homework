package tut8;

public class SportsCar extends Car {

    public SportsCar() {
        price = 100_000;
        doors = 5;
        engineType = 8;
        zeroToHundred = 4;
        numberOfGears = 6;
    }

    @Override
    public void slowDown() {
        currentVelocity -= 10;
    }

    @Override
    public void drift() {
        System.out.println("looks cool");
    }
}
