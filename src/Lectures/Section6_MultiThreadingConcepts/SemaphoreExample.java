package Lectures.Section6_MultiThreadingConcepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader{
    INSTANCE;

    private Semaphore semaphore = new Semaphore(3, true);

    public void download(){
        try {
            semaphore.acquire();
            downloadData();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally{
            semaphore.release();
        }
    }

    private void downloadData() {
        try {
            System.out.println("Downloading data from web...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class SemaphoreExample {
    /**
     *      It is used to control access to a shared resource
     *          that uses a counter variable
     *
     *         //semaphore maintains a set of permits
     *
     *   - acquires() ... if a permit is available then take it
     *   - release() ... adds a permit
     *
     *          semaphore just keeps a count of number of permits available
     *              new semaphore(int permits, boolean fail) !!!
     *
     */
    public static void main(String[] args) {
        //create Multiple threads
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 12; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    Downloader.INSTANCE.download();
                }
            });
        }
    }

}
