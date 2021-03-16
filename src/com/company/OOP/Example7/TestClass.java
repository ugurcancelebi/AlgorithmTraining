package com.company.OOP.Example7;

import java.util.*;


class Bill implements Comparable<Bill>{
    private int value;
    private String serialNumber;

    public Bill(int value, String serialNumber) {
        this.value = value;
        this.serialNumber = serialNumber;
    }

    public int getValue() {
        return value;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public int compareTo(Bill bill) {
        return Integer.compare(this.getValue(), bill.getValue());
    }
}

public class TestClass {
    static List<Bill> walletList = new ArrayList<>();

    public static void main(String[] args) {
        walletList.add(new Bill(10,"AABCDEF"));
        walletList.add(new Bill(50,"AABCDEF"));
        walletList.add(new Bill(20,"AABCDEF"));
        walletList.add(new Bill(50,"AABCDEF"));
        walletList.add(new Bill(10,"AABCDEF"));
        Collections.sort(walletList);
        walletList.forEach(a -> System.out.println(a.getValue() + a.getSerialNumber()));
    }
}
