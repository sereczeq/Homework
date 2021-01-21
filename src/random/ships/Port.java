package random.ships;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Port {
    private final int maxDocks;
    private int currentDocks = 0;
    private final int maxTugs;
    private int currentTugs = 0;
    private boolean isOpen = true;

    public Port(int maxDocks, int maxTugs) {
        this.maxDocks = maxDocks;
        this.maxTugs = maxTugs;
    }

    public void close()
    {
        isOpen = false;
    }

    public boolean dock(Ship ship) {
        if (currentDocks < maxDocks) {
            currentDocks++;
            return true;
        }
        return false;
    }

    public boolean unDock(Ship ship) {
        if (currentTugs + ship.getTugs() < maxTugs) {
            currentDocks -= 1;
            currentTugs += ship.getTugs();
            return true;
        }
        return false;
    }

    public void returnTugs(Ship ship) {
        currentTugs -= ship.getTugs();
    }

    @Override
    public String toString() {
        return "Port{" +
                "currentDocks=" + currentDocks +
                ", currentTugs=" + currentTugs +
                '}';
    }

    Runnable ships() {
        Random random = new Random();
        new Thread(info()).start();
        return () -> {
            int ID = 0;
            while (isOpen) {
                try {
                    TimeUnit.SECONDS.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Ship ship = new Ship(ID++);
                while (!dock(ship)) {
                    System.out.println("Port is full");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                new Thread(dockShip(ship)).start();
                System.out.println("DOCKED: "+ ship);
            }
        };
    }

    Runnable dockShip(Ship ship) {
        return () -> {
            try {
                TimeUnit.SECONDS.sleep(ship.getDockTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (!unDock(ship)) {
                System.out.println("Can't undock");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("UNDOCKED: " + ship);
            new Thread(tugShip(ship)).start();
        };
    }

    Runnable tugShip(Ship ship) {
        return () -> {
            try {
                TimeUnit.SECONDS.sleep(ship.getTugTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("FREED TUGS: " + ship);
            returnTugs(ship);
        };
    }

    Runnable info() {
        return () -> {
            while (isOpen) {
                System.out.println(this);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

}
