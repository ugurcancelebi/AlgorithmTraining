package com.company.OOP;

interface calculateInterface{
     int calcCoordination(int longitude,int latitude);
}
interface calculateImplementation{
    int calcImp(int odd,int even);
}
public class InterfaceExample implements calculateInterface,calculateImplementation{

    public static void main(String[] args) {
        InterfaceExample i = new InterfaceExample();
        System.out.println(i.calcCoordination(40,50));
        System.out.println(i.calcImp(40,50));
    }

    @Override
    public int calcCoordination(int longitude, int latitude) {
        return longitude*latitude;
    }

    @Override
    public int calcImp(int odd, int even) {
        return odd+even;
    }
}
