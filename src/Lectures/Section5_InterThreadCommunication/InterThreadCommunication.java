package Lectures.Section5_InterThreadCommunication;

public class InterThreadCommunication {
    public static Integer counter = 0;
    //we have to make sure this method is called only by a single thread at a given time
    public static synchronized void increement(){
        counter++;
    }

    public static void process(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<100; i++){
                    increement();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<100; i++){
                    increement();
                }
            }
        });

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The counter is: " + counter);
    }

    public static void main(String[] args) {
        process();

    }

}
