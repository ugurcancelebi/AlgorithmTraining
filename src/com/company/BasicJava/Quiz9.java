package com.company.BasicJava;

class Plant {
    protected String shape;
    public Plant(String shape){
        this.shape = shape;
    }
}
class Flower extends Plant{
    public Flower(String shape){
        super(shape);
    }
}
class Grass extends Plant{
    public Grass(String shape){
        super(shape);
    }
}
public class Quiz9 {
    public static void main(String[] args) {
        Plant plant = new Flower("Heart");
        System.out.println(plant instanceof  Plant);
    }
}
