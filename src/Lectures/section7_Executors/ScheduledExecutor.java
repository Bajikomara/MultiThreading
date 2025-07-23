package Lectures.section7_Executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

class stockMarketUpdater implements Runnable {

    @Override
    public void run() {
        System.out.println("Updating and downloading the stock related data from web");
    }
}

public class ScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(new stockMarketUpdater(), 1000, 2000, MILLISECONDS);
    }
}
