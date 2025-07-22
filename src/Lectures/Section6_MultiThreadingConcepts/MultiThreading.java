package Lectures.Section6_MultiThreadingConcepts;


class Worker implements Runnable{
    //it will be stored in the main memory instead of caching
    private volatile boolean Terminated;
    @Override
    public void run() {
        while(!Terminated){
            System.out.println("Working class is Running");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isTerminated() {
        return Terminated;
    }
    public void setTerminated(boolean Terminated) {
        this.Terminated = Terminated;
    }
}

public class MultiThreading {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t1 = new Thread(worker);
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        worker.setTerminated(true);
        System.out.println("Algo is Terminated");
    }
}
