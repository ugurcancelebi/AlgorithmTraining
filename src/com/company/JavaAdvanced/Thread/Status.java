package com.company.JavaAdvanced.Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Status implements StatusMBean{
    private static final AtomicInteger tCount = new AtomicInteger();
    @Override
    public int getTransactionCount() {
        return tCount.get();
    }

    @Override
    public void wireTransfer(Account from, Account to, int count) {
        Lock.transferMoney(from,to,count);
    }
}
interface StatusMBean {
    int getTransactionCount();
    void wireTransfer(Account from,Account to,int count);
}