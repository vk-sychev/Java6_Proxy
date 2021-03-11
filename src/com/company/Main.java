package com.company;

import javax.swing.text.html.CSS;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	    //System.out.println(Calculator.calculateExpression(Calculator.createExpression()));
	    if (chooseOperMode()==1) {
            long startTime = System.currentTimeMillis();
            System.out.println(Calculator.calculateExpression(Calculator.createExpression()));
            long endTime = System.currentTimeMillis();
            System.out.println("Total execution time: " + (endTime-startTime) + "ms");
            System.out.println();
        }
	    else
        {
            long startTime = System.currentTimeMillis();
            int cores = Runtime.getRuntime().availableProcessors();
            BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(100);

            ThreadPoolExecutor executor = new ThreadPoolExecutor(cores, cores * 2,60, TimeUnit.SECONDS, queue, new RejectedHandler());
            int tasks = 100 + cores * 4;
            for (int i = 0; i < tasks; i++) {
                executor.execute(new CalculatorRunnable(i));
            }
            executor.shutdown();
            long endTime = System.currentTimeMillis();
            //executor.execute(new CalculatorRunnable(1));

            while (!executor.awaitTermination(10,
                    TimeUnit.SECONDS)) {
                System.out.println("Ожидаем завершения");
            }
            System.out.println("Все задачи завершены");
            System.out.println("Total execution time: " + (endTime-startTime) + "ms");
            System.out.println();
        }
    }

    public static int chooseOperMode() {
        boolean ok = false;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Выберите режим работы: 1 - однопоточный режим, 2 - многопоточный режим");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    ok=true;
                    in.close();
                    return 1;
                case 2:
                    ok=true;
                    in.close();
                    return 2;
                default:
                    System.out.println("Выбрано неверное значение, повторите \n");
                    //in.close();
            }
        }
        while (!ok);
        return 0;
    }
}
