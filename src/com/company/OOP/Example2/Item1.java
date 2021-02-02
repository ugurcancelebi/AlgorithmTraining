package com.company.OOP.Example2;

public class Item1 implements IPonderable {
    @Override
    public double getWeight() {
        return 100;
    }

    @Override
    public String toString() {
        return "Item1";
    }
}
