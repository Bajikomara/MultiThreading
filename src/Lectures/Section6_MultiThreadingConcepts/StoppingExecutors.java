package Lectures.Section6_MultiThreadingConcepts;



import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class worker implements Runnable {
    private int id;
    public worker(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("Task with id " + id + " is in work-thread id: " + Thread.currentThread().getId());
        long duration = (long) (Math.random()*5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}

public class StoppingExecutors {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executor.execute(new worker(i + 1));
        }
        // we prevent the executor to eecute any further tasks
        executor.shutdown();

        //terminate actual(running) tasks
        try {
            if(!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
