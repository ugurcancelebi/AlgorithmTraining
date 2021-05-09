package com.company.BasicJava;

class Parent {
    private String attr;
    public Parent(String str){
        attr = str + "*";
    }

    @Override
    public String toString() {
        return "Parent" +
                 attr;
    }
}
class Child extends Parent{
    private String field;
    public Child(){
        super("-");
    }

    @Override
    public String toString() {
        return "Child " + field ;
    }
}
public class Quiz10 {
    public static void main(String[] args) {
        Parent parent =(Parent) new Child();
        System.out.println(parent);
    }
}
