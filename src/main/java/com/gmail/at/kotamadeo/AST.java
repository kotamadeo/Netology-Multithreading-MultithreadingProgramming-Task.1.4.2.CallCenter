package com.gmail.at.kotamadeo;

import java.util.Queue;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class AST {
    private static final int MAX_CALL_AMOUNT = 200;
    private static final int CALL_GENERATION_SLEEPING_TIME = 3;

    private final Queue<String> queue;

    public AST(Queue<String> queue) {
        this.queue = queue;
    }

    public void putCalls() {
        try {
            for (int i = 0; i < MAX_CALL_AMOUNT; i++) {
                String number = "+7" + new Random().ints(10, 0, 9)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining());
                queue.add(number);
                SECONDS.sleep(CALL_GENERATION_SLEEPING_TIME);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
