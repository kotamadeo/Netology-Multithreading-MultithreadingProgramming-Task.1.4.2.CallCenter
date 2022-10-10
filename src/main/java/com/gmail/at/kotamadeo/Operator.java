package com.gmail.at.kotamadeo;

import java.util.Queue;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Operator {
    private final Queue<String> queue;
    private static final int PROBLEM_RESOLVING_TIME = 5;

    public Operator(Queue<String> queue) {
        this.queue = queue;
    }

    public void takeCall() {
        try {
            while (!queue.isEmpty()) {
                String call = queue.poll();
                if (call != null)
                    System.out.printf("%s разговаривает с %s.%n", call, currentThread().getName());
                SECONDS.sleep(PROBLEM_RESOLVING_TIME);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
