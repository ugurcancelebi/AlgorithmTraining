package com.company.OOP.Example2;

public class Main {
    public static void main(String[] args) {
        Item1 item1 = new Item1();
        Item2 item2 = new Item2();
        System.out.println("Heaviest item is : " + findHeaviest(item1,item2));
    }

    public static <T extends IPonderable> T findHeaviest(T item1, T item2){
        T max;
        if (item1.getWeight() <= item2.getWeight()){
            max = item2;
        }else {
            max = item1;
        }
        return max;
    }
}
