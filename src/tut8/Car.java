package tut8;

public abstract class Car {
    int price;
    int doors;
    int engineType;
    int zeroToHundred;
    int numberOfGears;

    int currentGear;
    int currentVelocity;

    public boolean upShift()
    {
        if (currentGear + 1 <= numberOfGears)
        {
            currentGear++;
            return true;
        }
        return false;
    }
    public boolean downShift()
    {
        if (currentGear - 1 >= 0)
        {
            currentGear--;
            return true;
        }
        return false;
    }
    public abstract void slowDown();
    public abstract void drift();

}
