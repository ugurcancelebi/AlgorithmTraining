package com.company.OOP;

@FunctionalInterface
interface TestInterface{
    void test();
    default void test1(){
        System.out.println("Functional");
    }
    static void test2(){
        System.out.println("Static");
    }
}

abstract class TestAbstract{
    void testClass(String text) {
        System.out.println(text);
    }
}

class BiggerData extends TestAbstract implements TestInterface{
    String data;
    public BiggerData() {
        this.data = "Bigger data class";
    }

    public String getData() {
        return data;
    }

    @Override
    void testClass(String text) {
        super.testClass(text);
    }

    @Override
    public void test() {
        System.out.println("Boo" + data);
    }
}

class Data extends BiggerData {
    private final String data;
    public Data(){
        super();
        this.data = "Data class";
    }

    public String getData() {
        return data;
    }
}

public class Abstraction {
    public static void main(String[] args) {
        BiggerData data = new Data();
        data.test();
        data.test1();
        data.testClass("Whoa!");
        System.out.println(data.getData());
        TestInterface.test2();
    }
}
