package com.company.JavaAdvanced.Thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

class Consumer {
     void consume(){
        if (Mediator.QUEUE.size() > 0) {
            synchronized (Mediator.LOCK) {
                Mediator.QUEUE.poll(); 
                Mediator.LOCK.notify();
            }
        }else{
            try {
                Mediator.LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
     }
}
class Mediator {
    static final Queue<Integer> QUEUE = new LinkedList<>();
    static final ReentrantLock LOCK = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Consumer consumer = new Consumer();
        Producer producer = new Producer();
        for (int i = 0;i<10;i++){
            Thread a = new Thread(()->{
                while (!Thread.currentThread().isInterrupted()){ producer.produce();}},"Producer " + i);
            a.start();
        }
        for (int i = 0;i<10;i++){
            Thread b = new Thread(()->{
                while (!Thread.currentThread().isInterrupted()){ consumer.consume();}},"Consumer " + i);
            b.start();
        }
       Thread.sleep(1000);
    }
}
class Producer {
    private Random random = new Random();
    void produce(){
        try {
            Mediator.LOCK.lock();
            if (Mediator.QUEUE.size() < 10) {
                Mediator.QUEUE.add(random.nextInt());
            } else {
                try {
                    Mediator.LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (Mediator.QUEUE.size() > 10) {
                System.out.println(Mediator.QUEUE.size());
            }
        } finally {
            Mediator.LOCK.unlock();
        }
    }
}
