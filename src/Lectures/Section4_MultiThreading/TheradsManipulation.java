package Lectures.Section4_MultiThreading;

class Runner1 implements Runnable {
    @Override
    public void run() {
        for(int i= 0; i < 100 ; i ++){
            System.out.println("Runner 1: " + i);
        }
    }
}

class Runner2 implements Runnable {
    @Override
    public void run() {
        for(int i= 0; i < 100 ; i ++){
            System.out.println("Runner 2: " + i);
        }
    }
}

public class TheradsManipulation {

    public static void main(String[] args) {

//        Thread t1 = new Thread(new Runner1());
//        Thread t2 = new Thread(new Runner2());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Runner 1: " + i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Runner 2: " + i);
                }
            }
        });

        t1.start();
        t2.start();

    }
}
