package com.company.DataStructures;

import java.util.Scanner;

class AbstractExample extends AbstractClass{
    @Override
    protected int multiplyNums(int var1, int var2) {
        return var1*var2;
    }
    @Override
    public int divideNums(int var1, int var2) {
        return var1/var2;
    }
    @Override
    public void writeResult() {
        super.writeResult();
    }
}
class Main {
    public static void main(String[] args) {
        int num1 = new Scanner(System.in).nextInt();
        int num2 = new Scanner(System.in).nextInt();
        AbstractExample a = new AbstractExample();
        System.out.println(a.divideNums(num1,num2));
        System.out.println(a.multiplyNums(num1,num2));
    }
}
