package com.company.OOP.Example1;

public class ClassA {
    int n;
    public ClassA(){
        System.out.println("Class A is created");
    }
    public ClassA(int n){
        this.n = n;
        System.out.println("ClassA is created with n:" + this.n);
    }
    public void method1(){
        System.out.println("Method 1 is called with ClassA");
    }
}
