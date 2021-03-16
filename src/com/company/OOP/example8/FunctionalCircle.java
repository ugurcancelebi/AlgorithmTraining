package com.company.OOP.example8;

@FunctionalInterface
interface Square
{
    double calculate(double radius);
}

class FunctionalCircle
{
    static final double PI = 3.14;
    public static void main(String args[])
    {
        double radius = 5;
        if (radius > 0) {
            Square s = (x) -> (2 * PI * x);
            double ans = s.calculate(radius);
            System.out.println(ans);
        } else {
            System.out.println("Please select valid number");
        }
    }
}
