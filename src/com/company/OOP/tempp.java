package com.company.OOP;

class Employee {
    static int base = 10000;
    int getSalary(){
        return base;
    }
}
class Manager extends Employee{
    int getSalary(){
        return base + 20000;
    }
}
class Clerk extends Employee{
    int getSalary(){
        return base + 10000;
    }
}
public class tempp {
    private static void printSalary(Employee employee){
        System.out.println(employee.getSalary());
    }

    public static void main(String[] args) {
        Employee employee = new Manager();
        printSalary(employee);
        Employee employee1 = new Clerk();
        printSalary(employee1);
    }
}
