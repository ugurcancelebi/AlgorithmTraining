package com.company.JavaAdvanced.Thread;

import java.util.Random;

public class ThreadLocalRunner implements Runnable {
    private ThreadLocal<Integer> maxValue = new ThreadLocal<>();
    private Random random = new Random();
    private ThreadLocalRunner(){
        maxValue.set(0);
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Integer current = random.nextInt();
            if (maxValue.get() == null || current > maxValue.get()) {
                maxValue.set(current);
                System.out.println(Thread.currentThread().getName() + " New max number found : " + current);
                try {
                    Thread.sleep(223);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalRunner threadLocalRunner = new ThreadLocalRunner();
        for (int i = 0 ; i<10;i++){
            Thread thread = new Thread(threadLocalRunner,"Runner "+i);
            thread.start();
        }
        Thread.sleep(4000);
    }
}
