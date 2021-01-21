package random.ships;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        Port port = new Port(10, 30);
        new Thread(port.ships()).start();
        TimeUnit.SECONDS.sleep(600);
        port.close();
    }


}

