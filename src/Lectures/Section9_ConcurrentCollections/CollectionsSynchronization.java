package Lectures.Section9_ConcurrentCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSynchronization {
    public static void main(String[] args) {
        //add and remove methods are synchronized
        //Intrinsic Lock - not the efficient method because threads have to wait  for each other even when they want to execute
        //Independent methods (operation)

        List<Integer> nums = Collections.synchronizedList(new ArrayList<>());
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 1000; i++) {
                    nums.add(i);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 1000; i++) {
                    nums.add(i);
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
        System.out.println("Size of the array: " + nums.size());
    }
}
