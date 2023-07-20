package com.in28minutes.multithreading;

import java.util.concurrent.*;

class CallableTask implements Callable<String> {

    private final String name;

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello " + name;
    }
}

public class CallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> welcomeFuture = executorService.submit(new CallableTask("in28Minutes"));
        System.out.print("new CallableTask(\"in28Minutes\") executed \n");
        String welcomeMessage = welcomeFuture.get();
        System.out.print(welcomeMessage);
        Future<String> welcomeFuture1 = executorService.submit(new CallableTask("Ranga"));
        System.out.print("\nnew CallableTask(\"Ranga\") executed \n");
        String welcomeMessage1 = welcomeFuture1.get();
        System.out.print(welcomeMessage1);
        System.out.print("\nMain completed");
        executorService.shutdown();
    }
}
