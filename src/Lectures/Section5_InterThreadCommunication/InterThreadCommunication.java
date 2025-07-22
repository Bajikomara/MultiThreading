package Lectures.Section5_InterThreadCommunication;

class Process{
    public void produce() throws InterruptedException{
        synchronized(this){
            System.out.println("Running the produce Method....");
            wait();
            System.out.println("Again Inside Process produce Method");
        }
    }

    public void consume() throws InterruptedException{
        Thread.sleep(1000);
        synchronized(this){
            System.out.println("consume Method is executed.......");
            notify();
            //it is not going to handle the lock: we can make fuurthet operations
            Thread.sleep(3000);
        }

    }
}

public class InterThreadCommunication {

    public static void main(String[] args) {
        Process p = new Process();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    p.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

    }

}
