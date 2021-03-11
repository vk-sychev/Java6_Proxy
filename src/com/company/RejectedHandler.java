package com.company;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r,
                                  ThreadPoolExecutor e) {
        System.out.printf("Задача \"%s\" отклонена\n", r);
    }
}
