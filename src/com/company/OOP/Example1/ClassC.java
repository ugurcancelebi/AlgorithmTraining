package com.company.OOP.Example1;

public class ClassC extends ClassA{
    public ClassC(){
        super();
        System.out.println("ClassC is created");
    }
    public void method1(){
        System.out.println("Method1 is called with ClassC");
    }
    public void method3(){
        method1();
        super.method1();
    }
}
