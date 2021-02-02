package com.company.OOP.Example1;

public class ClassB extends ClassA{
    int m;
    public ClassB(){
        System.out.println("ClassB is created");
    }
    public ClassB(int n,int m){
        super(n);
        System.out.println("ClassB is created with m:" + m);
    }
    public void method1(){
        super.method1();
        System.out.println("Method1 is called with ClassB");
    }
    public void method2(){
        System.out.println("Method2 is called with ClassB");
    }
}
