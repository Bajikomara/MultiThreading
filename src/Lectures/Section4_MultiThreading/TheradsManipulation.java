package Lectures.Section4_MultiThreading;

class worker implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(i);
        }
    }
}


public class TheradsManipulation {

    public static void main(String[] args) {

//        System.out.println(Thread.currentThread().getName());
//
//        System.out.println(Thread.currentThread().getPriority());
//
//        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
//
//        System.out.println(Thread.currentThread().getPriority());

        Thread t = new Thread(new worker());
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
        System.out.println("This is in the main Thread");


    }
}
