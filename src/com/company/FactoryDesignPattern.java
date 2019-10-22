package com.company;

interface furnitureType {
    void draw();
}
class DIYSofa implements furnitureType {
    @Override
    public void draw() {
        System.out.println("Sofa built by customer");
    }
}
class DIYChair implements furnitureType {
    @Override
    public void draw() {
        System.out.println("Chair built by customer");
    }
}
class Sofa implements furnitureType {
    @Override
    public void draw() {
        System.out.println("Sofa built by producer");
    }
}
class Chair implements furnitureType {
    @Override
    public void draw() {
        System.out.println("Chair built by producer"); 
    }
}
abstract class AbstractFactory {
    abstract Sofa getSofa();
    abstract Chair getChair();
    abstract DIYChair getIKEAChair();
    abstract DIYSofa getIKEASofa();
}
class FurnitureFactory extends AbstractFactory {
    @Override
    Sofa getSofa() {
        return new Sofa();
    }
    @Override
    Chair getChair() {
        return new Chair();
    }
    @Override
    DIYChair getIKEAChair() {
        return new DIYChair();
    }
    @Override
    DIYSofa getIKEASofa() {
        return new DIYSofa();
    }
}
class FactoryProducer {
    static AbstractFactory getFactory(){
        return new FurnitureFactory();
    }
}
class FactoryDesignPatterns {
    public static void main(String[] args) {
        AbstractFactory producerFactory = FactoryProducer.getFactory();
        furnitureType type1 = producerFactory.getSofa();
        type1.draw();
        furnitureType type2 = producerFactory.getChair();
        type2.draw();
        AbstractFactory userFactory = FactoryProducer.getFactory();
        furnitureType type3 = userFactory.getIKEASofa();
        type3.draw();
        furnitureType type4 = userFactory.getIKEAChair();
        type4.draw();

    }
}
