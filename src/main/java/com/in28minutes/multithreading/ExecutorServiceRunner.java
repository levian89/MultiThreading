package com.in28minutes.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task extends Thread {

    private final int number;

    public Task(int number) {
        this.number=number;
    }
    
    public void run() { //Signature
        System.out.print("\nTask " + number + " Started ");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        for(int i=number*100;i<=number*100+99;i++)
            System.out.print(i + " ");
        System.out.print("\nTask " + number + " Done ");
    }
}

public class ExecutorServiceRunner {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor(); //executes only 1 Thread at a time
//        ExecutorService executorService = Executors.newFixedThreadPool(2); //executes multiple Threads(2) at a time
//        executorService.execute(new Task1());
//        executorService.execute(new Thread(new Task2()));
        ExecutorService executorService = Executors.newFixedThreadPool(1);//there are maximum 5 Threads active at
        executorService.execute(new Task(1));                               // any point in time
        executorService.execute(new Task(2));
        executorService.execute(new Task(3));
        executorService.execute(new Task(4));
        executorService.execute(new Task(5));
        executorService.execute(new Task(6));
        executorService.execute(new Task(7));
        executorService.shutdown();
//        //Task3
//        System.out.print("\nTask3 Kicked Off ");
//        for(int i=301;i<=399;i++)
//            System.out.print(i + " ");
//        System.out.print("\nTask3 Done ");
//        System.out.print("\nMain Done ");
    }
}
