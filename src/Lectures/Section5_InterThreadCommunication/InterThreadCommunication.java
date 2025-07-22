package Lectures.Section5_InterThreadCommunication;

public class InterThreadCommunication {
    public static Integer counter1 = 0;
    public static Integer counter2 = 0;
    //because App object has a single lock: this why the methods
    // cannot be executed "at the same time"-time slicing algorithm
//    public static synchronized void increement1(){
//        counter1++;
//    }

    public static  void increement1(){
//        class level locking
//        rule of thumb: we synchronize blocks that are 100% necessary
        synchronized (InterThreadCommunication.class){
            counter1++;
        }
    }

    public static synchronized void increement2(){
        synchronized (InterThreadCommunication.class){
            counter2++;
        }
    }

    public static void process(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<100; i++){
                    increement1();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<100; i++){
                    increement2();
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

        System.out.println("The counter is: " + counter1);
        System.out.println("The counter is: " + counter2);
    }

    public static void main(String[] args) {
        process();

    }

}
