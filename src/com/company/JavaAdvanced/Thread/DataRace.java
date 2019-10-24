package com.company.JavaAdvanced.Thread;

class Waiter implements Runnable{
    private boolean shouldFinish;
    void finish(){ shouldFinish = true; }
    @Override
    public void run() {
        long iteration = 10;
        while (!shouldFinish){
            iteration--;
        }
        System.out.println("Finished after : " + iteration);
    }
}
public class DataRace {
    public static void main(String[] args) throws InterruptedException {
        int count = 10;
        while (count > 0) {
            Waiter waiter = new Waiter();
            Thread waiterThread = new Thread(waiter);
            waiterThread.start();
            waiter.finish();
            waiterThread.join();
            count--;
        }
    }
}
