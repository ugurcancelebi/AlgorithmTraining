package com.company.BasicJava;

class Car {
    private double price;
    public Car(){
        price = -1;
    }
    public Car(double price){
        this.price = price;
    }
    public double raisePrice(){
        return price * 1.1;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                '}';
    }
}
class RaceCar extends Car{
    public RaceCar (double price){
        super(2*price);
    }
}
public class Quiz11  {
    public static void main(String[] args) {
        Car car = new Car(1000);
        Car fastCar = new RaceCar(2000);
        System.out.println(car);
        System.out.println(car.raisePrice());
        System.out.println(fastCar);
    }
}
