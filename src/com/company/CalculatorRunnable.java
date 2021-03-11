package com.company;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class CalculatorRunnable implements Runnable {

    private final int indx;

    public CalculatorRunnable(int indx) {
        this.indx = indx;
    }

    @Override
    public void run() {
        System.out.printf("Стартуем задачу %d " +
                "в потоке %s\n", indx, Thread.currentThread());
        Calculator.calculateExpression(Calculator.createExpressionMulti());
        System.out.printf("Задача %d в потоке %s " +
                "завершилась\n", indx, Thread.currentThread());

    }

    @Override
    public String toString() {
        return "Задача " + indx;
    }
}


