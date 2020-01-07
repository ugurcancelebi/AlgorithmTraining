package com.company.OOP;

import java.util.Scanner;
abstract class AbstractClass{
    protected abstract int multiplyNums(int var1,int var2);
    protected abstract int divideNums(int var1,int var2);
    protected void writeResult(){
        System.out.println("Result : ");
    }
}
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
