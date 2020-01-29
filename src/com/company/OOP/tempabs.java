package com.company.OOP;
abstract class Shape{
    private String color;
    abstract double area();
    public void getData(){
        System.out.println("fuk");
    }
    public abstract String toString();

    Shape (String color){
        this.color = color;
    }
    String getColor() {
        return color;
    }
}
class Circle extends Shape{
    @Override
    public void getData() {
        super.getData();
    }

    private double radius;
    Circle(String color,double radius) {
        super(color);
        System.out.println("Circle constructor is called ");
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public String toString() {
        return "Color of the circle is : " + super.getColor() + "and area is : " + area();
    }
}
class Rectangle extends Shape {
    private int width,height;
    Rectangle(String color,int width,int height) {
        super(color);
        System.out.println("Rectangle constructor is called");
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width*height;
    }

    @Override
    public String toString() {
        return "Color is : " + super.getColor() + "Area is : " + area();
    }
}
public class tempabs{
    public static void main(String[] args) {
        Shape circle = new Circle("RED ",2.3);
        System.out.println(circle.toString());
        circle.getData();
        Shape rectangle = new Rectangle("BLUE ",2,4);
        System.out.println(rectangle.toString());
    }
}
