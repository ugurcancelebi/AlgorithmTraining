package com.company.JavaAdvanced.Thread;

import java.util.stream.IntStream;

public class Lock {
    public static void main(String[] args) throws InterruptedException {
        Account a = new Account(1,100);
        Account b = new Account(2,100);
        Thread transferA = new Thread(()->{
            IntStream.range(1,100).forEach(i->{transferMoney(a,b,1);});
        });
        Thread transferB = new Thread(()->{
            IntStream.range(1,100).forEach(i->{transferMoney(b,a,1);});
        });
        transferA.start();
        transferB.start();
        transferA.join();
        transferB.join();
        System.out.println("Balance account for A " + a.getBalance());
        System.out.println("Balance account for B " + b.getBalance());
    }
     static void transferMoney(Account from, Account to,int amount) {
        Account first = from.getId()>to.getId()?from:to;
        Account second = to.getId()>to.getId()?to:from;
        synchronized (first) {
            synchronized (second) {
                from.updateBalance(-amount);
                to.updateBalance(amount);
            }
        }
    }
}
class Account {
    private int balance;
    private int id;

    Account(int id ,int balance) {
        this.balance = balance;
        this.id = id;
    }
    int getId(){
        return id;
    }
    int getBalance() {
        return balance;
    }
    void updateBalance(int amount)
    {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance += amount;
    }
}
