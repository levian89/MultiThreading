package com.in28minutes.multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallableRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<CallableTask> callableTasks = List.of(new CallableTask("in28Minutes"),
                new CallableTask("Ranga"), new CallableTask("Adam"));
        List<Future<String>> results = executorService.invokeAll(callableTasks);
//        System.out.print("new CallableTask(\"in28Minutes\") executed \n");
//        System.out.print("new CallableTask(\"Ranga\") executed \n");
//        System.out.print("new CallableTask(\"Adam\") executed \n");
        for (Future<String> result:results) {
            System.out.println(result.get());
        }
        executorService.shutdown();
    }
}
