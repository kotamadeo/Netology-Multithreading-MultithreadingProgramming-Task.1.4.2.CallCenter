package com.gmail.at.kotamadeo;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Main {
    private static final int OPERATORS_COUNT = 5;
    private static final int CALL_TIME_INTERVAL = 20;

    public static void main(String[] args) throws InterruptedException {
        Queue<String> blockingQueue = new ConcurrentLinkedQueue<>();
        new Thread(new AST(blockingQueue)::putCalls).start();
        SECONDS.sleep(CALL_TIME_INTERVAL);
        for (int i = 1; i <= OPERATORS_COUNT; i++) {
            new Thread(new Operator(blockingQueue)::takeCall, "Оператор " + i).start();
        }
    }
}